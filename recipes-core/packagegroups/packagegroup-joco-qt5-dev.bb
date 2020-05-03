SUMMARY = "Qt5 Dev Packages on Target for Joco Projects"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT5_DEV_ESSENTIALS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-staticdev \
    qtbase-tools \
"

QT5_DEV_ADD_ONS = " \
    qtscript-dev \
    qtscript-mkspecs \
    \
    qtserialport-dev \
    qtserialport-mkspecs \
"

QT5_DEV_PKGS = " \
    qtdeclarative-dev \
    qtdeclarative-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtdeclarative-qmlplugins', '', d)} \
    qtdeclarative-staticdev \
    qtdeclarative-tools \
    \
    qtquickcontrols2 \
    qtquickcontrols2-dev \
    qtquickcontrols2-mkspecs \
    \
    qtwebsockets-dev \
    qtwebsockets-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebsockets-qmlplugins', '', d)} \
    \
    qtxmlpatterns-dev \
    qtxmlpatterns-mkspecs \
"

QT5_DEV_X11_EXTRA = " \
    qtx11extras-dev \
    qtx11extras-mkspecs \
"

RDEPENDS_${PN} = "\
    ${QT5_DEV_ESSENTIALS} \
    ${QT5_DEV_ADD_ONS} \
    ${QT5_DEV_PKGS} \
"
