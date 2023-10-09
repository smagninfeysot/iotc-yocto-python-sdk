LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

RDEPENDS_${PN} = "iotc-python-sdk iotc-telemetry-demo-service"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

APP_INSTALL_DIR = "${D}${bindir}/iotc"

SRC_URI += "file://files/"
FILES_${PN} += "${bindir}/*"

# Create /usr/bin in rootfs and copy program to it
do_install_append() {
    install -d ${APP_INSTALL_DIR}
    cp -r --no-preserve=ownership ${WORKDIR}/files/* ${APP_INSTALL_DIR}/
    install -m 0755 ${WORKDIR}/files/telemetry_demo.py ${APP_INSTALL_DIR}/
}