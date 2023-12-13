SUMMARY = "maaxboard specific systemd files"
DESCRIPTION = "recipe for adding maaxboard specific scripts"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS_${PN} = "bash"

SRC_URI += "file://control_led.sh \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_${PN} += "${APP_INSTALL_DIR}/scripts/control_led.sh \
"

APP_INSTALL_DIR = "${base_prefix}/usr/bin/local/iotc"

do_install_append() {
    install -d ${D}${APP_INSTALL_DIR}/scripts/
    install -m 0755 ${WORKDIR}/control_led.sh ${D}${APP_INSTALL_DIR}/scripts/
}
