SUMMARY = "Joco x11 Debug/Dev Image"
HOMEPAGE = "https://about.jocodoma.com/"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

require core-image-joco-x11-base.bb

# For more info:
# https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#ref-features-image
EXTRA_IMAGE_FEATURES += "debug-tweaks"
EXTRA_IMAGE_FEATURES += "tools-debug"
# EXTRA_IMAGE_FEATURES += "tools-profile"
# EXTRA_IMAGE_FEATURES += "tools-sdk"

# more options can be found in recipes-core/packagegroups/packagegroup-dev-target.bb
JOCO_DEV_PKGS = " \
    evtest \
    gdbserver \
    glibc-utils \
    htop \
    localedef \
    nano \
"

IMAGE_INSTALL += " \
    ${JOCO_DEV_PKGS} \
"

set_auto_login() {
    # /usr/bin/autologin
    touch ${IMAGE_ROOTFS}/usr/bin/autologin
    echo "#!/bin/sh" >> ${IMAGE_ROOTFS}/usr/bin/autologin
    echo "exec /bin/login root" >> ${IMAGE_ROOTFS}/usr/bin/autologin
    chmod a+x ${IMAGE_ROOTFS}/usr/bin/autologin

    # /etc/inittab
    sed -i 's/mxc1/#mxc1/' ${IMAGE_ROOTFS}/etc/inittab
    sed -i '/#mxc1/a mxc1:12345:respawn:/sbin/getty -n -L -l /usr/bin/autologin 115200 ttymxc1 vt102' ${IMAGE_ROOTFS}/etc/inittab
}

ROOTFS_POSTPROCESS_COMMAND += " \
    ${@oe.utils.conditional('DISTRO', 'poky', '', 'set_auto_login ;', d)} \
"
