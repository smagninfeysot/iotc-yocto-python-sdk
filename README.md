# iotc-yocto-python-sdk
*The following details yocto layers designed to integrate the [iotc Python SDK]([https://github.com/avnet-iotconnect/iotc-python-sdk/tree/master-std-21]). The end result is an image with the SDK repo & a couple of sample python scripts installed. Once said image is flashed to a target, the sample scripts should successfully run & establish comms with an appropriately setup device on https://avnet.iotconnect.io/*

## Layers
There are 2 layers thus far: `meta-iotc-python-sdk` & `meta-my-iotc-python-sdk-example`.
### How to include layers
To include the layers within a yocto enviroment:

1. check them out to the `sources` directory in your yocto enviroment.

1. add them to `conf/bblayers` file in your build directory
2. add the recipes to your build target e.g. add `IMAGE_INSTALL += " iotc-python-sdk"` to the bottom of `build/conf/local.conf`

1. build with a bitbake call e.g. `./bitbake iot-connect-image`

### Description of layers
#### meta-iotc-python-sdk
Contains the git urls for checkouts, recipe definitions & additional python module requirements.
#### meta-my-iotc-python-sdk-example
It's expected that developers will have to provide bespoke elements for their application. This layer provides an example of how a user might specify custom requirements of an application within their layer that's then compiled & built for use: in this case the  specifics that need to be edited with the device credentials.
