SUMMARY = "maaxboard specific systemd files"
DESCRIPTION = "recipes for adding maaxboard systemd files"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

RDEPENDS_${PN} = "bash"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_SERVICE_${PN} = "iotc-set-perms.service"

SRC_URI += "file://iotc-set-perms.service \
    file://iotc-demo.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_append() {
    install -m 0644 ${WORKDIR}/iotc-set-perms.service ${D}/${systemd_unitdir}/system
}
