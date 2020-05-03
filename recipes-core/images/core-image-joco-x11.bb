SUMMARY = "Joco x11 Image"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

require recipes-graphics/images/core-image-x11.bb

# GLIBC_GENERATE_LOCALES = "en_US.UTF-8"
IMAGE_FEATURES_append = " ssh-server-dropbear hwcodecs"
# IMAGE_FEATURES_remove = "splash"
IMAGE_FSTYPES += "tar.bz2"
# IMAGE_LINGUAS = "en-us"

BSP = " \
    u-boot-imx \
    linux-imx \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

TIME_ZONE = " \
    tzdata \
"

TSLIB = " \
    tslib \
    tslib-conf \
    tslib-calibrate \
    tslib-tests \
"

X11_TOOLS = " \
    xdotool \
"

IMAGE_INSTALL += " \
    ${@oe.utils.conditional('DISTRO', 'poky', '', '${BSP}', d)} \
    packagegroup-joco-qt5 \
    ${TIME_ZONE} \
    ${X11_TOOLS} \
"

# Post processing
IMAGE_BLACKLIST_FILES += " \
    /etc/init.d/hwclock.sh \
 "

remove_blacklist_files() {
    for i in ${IMAGE_BLACKLIST_FILES}; do
        rm -rf ${IMAGE_ROOTFS}$i
    done
}

set_local_timezone() {
    # ln -sf /usr/share/zoneinfo/Asia/Seoul ${IMAGE_ROOTFS}/etc/localtime
    ln -sf /usr/share/zoneinfo/America/Los_Angeles ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
    remove_blacklist_files ; \
    set_local_timezone ; \
"
