SUMMARY = "maaxboard specific systemd files"
DESCRIPTION = "recipes for grabbing open data about the voyager probes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

RDEPENDS_${PN} = "bash"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "iotc-set-perms.service"

SRC_URI += "file://iotc-set-perms.service \
	file://control_led.sh \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_${PN} += "${APP_INSTALL_DIR}/scripts/control_led.sh \
"

APP_INSTALL_DIR = "${base_prefix}/usr/bin/local/iotc"

do_install_append() {
    install -m 0644 ${WORKDIR}/iotc-set-perms.service ${D}/${systemd_unitdir}/system
    install -d ${D}${APP_INSTALL_DIR}/scripts/
    install -m 0755 ${WORKDIR}/control_led.sh ${D}${APP_INSTALL_DIR}/scripts/
}
