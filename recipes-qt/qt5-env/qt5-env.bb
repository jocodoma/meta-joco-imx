SUMMARY = "Qt5 Environment Setup"
HOMEPAGE = "https://github.com/jumpnow/meta-rpi/tree/zeus/recipes-qt/qt5-env"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://qt5-env.sh"

PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 qt5-env.sh ${D}${sysconfdir}/profile.d
}

FILES_${PN} = "${sysconfdir}"
