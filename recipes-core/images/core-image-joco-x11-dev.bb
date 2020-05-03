SUMMARY = "Joco x11 Dev Image"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

require core-image-joco-x11.bb

EXTRA_DEV_PKGS = " \
    evtest \
    nano \
    htop \
"

IMAGE_INSTALL += " \
    ${EXTRA_DEV_PKGS} \
"
