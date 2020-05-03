SUMMARY = "Qt5 Packages for Joco Projects"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT5_ESSENTIALS = " \
    qtbase \
"

QT5_ADD_ONS = " \
    qtscript \
    qtserialport \
"

QT5_PKGS = " \
    qtdeclarative \
    qtquickcontrols \
    qtquickcontrols2 \
    qtwebsockets \
    qtxmlpatterns \
"

QT5_PYTHON_PKGS += " \
    python3-pyqt5 \
    pytouch \
"

QT5_X11_EXTRA = " \
    qtx11extras \
"

RDEPENDS_${PN} = "\
    qt5-env \
    ${QT5_ESSENTIALS} \
    ${QT5_ADD_ONS} \
    ${QT5_PKGS} \
"
