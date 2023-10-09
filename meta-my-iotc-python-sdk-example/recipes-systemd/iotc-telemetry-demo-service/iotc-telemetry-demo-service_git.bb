LICENSE = "CLOSED"
inherit systemd


SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE_${PN} = "iotc-telemetry-demo.service"

SRC_URI_append = " file://iotc-telemetry-demo.service "
FILES_${PN} += "${systemd_unitdir}/system/iotc-telemetry-demo.service"

do_install_append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/iotc-telemetry-demo.service ${D}/${systemd_unitdir}/system
}
