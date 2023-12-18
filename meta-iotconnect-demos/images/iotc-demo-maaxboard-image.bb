SUMMARY = "MaaxBoard iotc demo"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
inherit extrausers

CORE_IMAGE_EXTRA_INSTALL_append = " iotc-demo-dev voyager-data openssh iotc-python-sdk"

EXTRA_USERS_PARAMS = " useradd -p '\$5\$qjMzQ4sWI8S\$AJ/zzrYE2PJoyM9e6QLOV.L/xyDn0Lmk2E/aH4wd7o.' iot; \
                       usermod -p '\$5\$qjMzQ4sWI8S\$AJ/zzrYE2PJoyM9e6QLOV.L/xyDn0Lmk2E/aH4wd7o.' root; \
                       usermod -a -G sudo iot;"
IMAGE_FSTYPES = "wic.gz"

