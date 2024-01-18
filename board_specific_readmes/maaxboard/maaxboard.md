####	*For a Quick Start initiation into IoTConnect, we recommend the [MaaxBoard-IoTC-Voyager-Demo](https://github.com/avnet-iotconnect/avnet-iotconnect.github.io/blob/main/documentation/iotc-yocto-c-sdk/voyager-demo/MaaxBoard-IoTC-Voyager-Demo.md). This pre-configured Yocto image facilitates a rapid onboarding of the MaaXBoard with IoTConnect, ensuring immediate data visibility in the cloud.
## MaaxBoard Example
In this MaaXBoard Example, developers are guided on how to integrate the `meta-iotconnect` and `meta-my-iotc-python-sdk-example` meta-layers into a Yocto build image. The aim is to expedite Linux development, allowing developers to focus on their unique applications rather than the intricacies of cloud connection.

* Notes:
	* Based on the MaaXBoard [Development Guide](https://www.avnet.com/wps/wcm/connect/onesite/35645cc9-4317-4ca0-a2fa-30cce5f9ff17/MaaXBoard-Mini-Linux-Yocto-Lite-Development_Guide-V1.0-EN.pdf?MOD=AJPERES) from [this page](https://www.avnet.com/wps/portal/us/products/avnet-boards/avnet-board-families/maaxboard/maaxboard?utm_source=hackster)

This is a demo to add Telemetry, Commands and Over the air update (OTA) functionality of IOTConnect using the Python SDK on a MaaXBoard Mini.

## Build Instructions

This demo leverages the power of Docker to create a reproducible build that works across different OS environments, one of the main ideas is to avoid problems caused by having a too old/new version of Linux being used the Yocto build system, as those can cause build failures.

Provided in the folder are both the `Dockerfile` and `Makefile` to simplify the build process.

You will need to create your own `config.json` inside `meta-my-iotc-python-sdk-example/recipes-apps/iotc-telemetry-and-commands-demo/files/eg-private-repo-data/` prior to building the image.

These instructions will add `iotc-demo-service` to your `local.conf` which will enable the systemd service for the demo application, to see the logs and output use
`journalctl -fu iotc-demo`.

To launch the application manually launch `~/iotc-application.sh` on the root user's home directory.

For OTA check the `meta-my-iotc-python-sdk-example/recipes-apps/iotc-telemetry-and-commands-demo/files/ota-payload-template` folder.

The root user credentials are `root` with the password `avnet`.

Tested on Kubuntu 23.10

# Requirements
- Repo tool (from Google) - https://android.googlesource.com/tools/repo
- Docker - https://docs.docker.com/engine/install/ubuntu/ + https://docs.docker.com/engine/install/linux-postinstall/#manage-docker-as-a-non-root-user
- git name and email added to global scope

# Method
1. Create a work directory, for example ~/work
    ```bash
    cd ~/work
    ```

2. Create project directory and enter it
    ```bash
    mkdir imx-yocto-bsp && cd imx-yocto-bsp
    ```

3. Use repo tool to get the yocto sources
    ```bash
    repo init -u https://github.com/nxp-imx/imx-manifest  -b imx-linux-hardknott -m imx-5.10.35-2.0.0.xml && repo sync
    
    git clone https://github.com/Avnet/meta-maaxboard.git -b hardknott sources/meta-maaxboard
    ```

4.  Copy provided Makefile to project directory and execute these commands in the terminal
    ```bash
    make docker
    
    MACHINE=maaxboard source sources/meta-maaxboard/tools/maaxboard-setup.sh -b maaxboard/build
    
    exit
    
    make build
    # this will take a while as this is the initial build.
    ```

5.  Now we will need to add the Yocto Python SDK layers

    ```bash
    # from the root project directory on the host machine
    git clone https://github.com/avnet-iotconnect/iotc-yocto-python-sdk.git -b hardknott ./sources/meta-iotconnect

    make env

    echo -e '\n' >> conf/bblayers.conf
    
    bitbake-layers add-layer ../../sources/meta-iotconnect/meta-iotc-python-sdk/
    
    bitbake-layers add-layer ../../sources/meta-iotconnect/meta-my-iotc-python-sdk-example/
    
    echo -e '\nIMAGE_INSTALL += " iotc-demo-dev iotc-demo-service packagegroup-core-boot kernel-modules"' >> ./conf/local.conf
    
    echo -e '\nDISTRO_FEATURES_append = " systemd"\nDISTRO_FEATURES_BACKFILL_CONSIDERED += " sysvinit"\nVIRTUAL-RUNTIME_init_manager = " systemd"\nVIRTUAL-RUNTIME_initscripts = " systemd-compat-units"\n' >> ./conf/local.conf
    
    echo -e '\nEXTRA_IMAGE_FEATURES=""
    INHERIT += "extrausers"
    EXTRA_USERS_PARAMS = "\ 
    \tusermod -P avnet root; \ 
    "' >> conf/local.conf  
    
    exit

    make build
    ```

6. If there are any problems during building then try:
    ```bash
        rm -rf ./maaxboard/build/tmp
        make build
    ```

### Extras

Instructions for using a serial adapter and UART are found [here](https://www.hackster.io/monica/getting-started-with-maaxboard-headless-setup-24102b)  
