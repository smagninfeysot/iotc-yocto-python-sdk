LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

RDEPENDS_${PN} = "iotc-python-sdk iotc-telemetry-demo-service"

SRC_URI = "file://telemetry_demo.py \
    file://model \
    file://eg-private-repo-data \
"

APP_INSTALL_DIR = "${base_prefix}/usr/bin/local/iotc"
PRIVATE_DATA_DIR = "${base_prefix}/usr/local/iotc"

FILES_${PN}-dev = "${PRIVATE_DATA_DIR}/* \
"

do_install() {
    install -d ${D}${APP_INSTALL_DIR}
    for f in ${WORKDIR}/model/*
    do
        if [ -f $f ]; then
            if [ ! -d ${D}${APP_INSTALL_DIR}/model ]; then
                install -d ${D}${APP_INSTALL_DIR}/model
            fi
            install -m 0755 $f ${D}${APP_INSTALL_DIR}/model/
        fi
    done
    install -m 0755 ${WORKDIR}/telemetry_demo.py ${D}${APP_INSTALL_DIR}/

    for f in ${WORKDIR}/eg-private-repo-data/*
    do
        if [ -f $f ]; then
            if [ ! -d ${D}${PRIVATE_DATA_DIR} ]; then
                install -d ${D}${PRIVATE_DATA_DIR}
            fi
            install -m 0755 $f ${D}${PRIVATE_DATA_DIR}/
        fi
    done
}
