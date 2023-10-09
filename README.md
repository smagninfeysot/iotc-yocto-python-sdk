# iotc-yocto-python-sdk
*The following details yocto layers designed to integrate the [iotc Python SDK]([https://github.com/avnet-iotconnect/iotc-python-sdk/tree/master-std-21]). The end result is an image with the SDK repo & a couple of sample python scripts installed. Once said image is flashed to a target, the sample scripts should successfully run & establish comms with an appropriately setup device on https://avnet.iotconnect.io/*

## Layers
There are 2 layers thus far: `meta-iotc-python-sdk` & `meta-my-iotc-python-sdk-example`.
### How to include layers
To include the layers within a yocto environment:

1. check them out to the `sources` directory in your yocto environment. For example, when in the directory above `sources`:

   ```
   git clone --depth=1 https://github.com/avnet-iotconnect/iotc-yocto-python-sdk.git --branch=hardknott /tmp/tmpcheckout && \
   mv /tmp/tmpcheckout/meta-* sources/ && \
   rm -fr /tmp/tmpcheckout/
   ```

1. add them to `conf/bblayers` file in your build directory
1. add the recipes to your build target e.g. add `IMAGE_INSTALL += " iotc-telemetry-demo"` to the bottom of `build/conf/local.conf`
1. build with a bitbake call e.g. `./bitbake core-image-base`

1. with a serial console, navigate to `/usr/bin/iotc`
2. use `nano` or `vi` to modify `credentials.json` with your device credentials
3. launch the application with `./telemetry-demo.py credentials.json`

### Description of layers
#### meta-iotc-python-sdk
Contains the git urls for checkouts, recipe definitions & additional python module requirements.
#### meta-my-iotc-python-sdk-example
It's expected that developers will have to provide bespoke elements for their application. This layer provides an example of how a user might specify custom requirements of an application within their layer that's then compiled & built for use: in this case the  specifics that need to be edited with the device credentials.

## Board specific examples can be found [here](board_specific_readmes/README.md)
