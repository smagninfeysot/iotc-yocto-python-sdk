FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI += "file://iotconnect-sdk-firmware-python-3.0.4.py"

FILES_${PN} += "${bindir}/iotconnect-sdk-firmware-python-3.0.4.py"

# Create /usr/bin in rootfs and copy program to it
do_install_append() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/iotconnect-sdk-firmware-python-3.0.4.py ${D}${bindir}
}
