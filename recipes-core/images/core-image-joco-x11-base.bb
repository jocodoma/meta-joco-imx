SUMMARY = "Joco x11 Base Image"
HOMEPAGE = "https://about.jocodoma.com/"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

require recipes-graphics/images/core-image-x11.bb

# Locale settings
GLIBC_GENERATE_LOCALES = "en_US.UTF-8"
IMAGE_LINGUAS = "en-us"

IMAGE_FSTYPES += "tar.bz2"
IMAGE_FSTYPES_remove = "wic.bmap wic.bz2 wic.gz"
IMAGE_FEATURES_append = " hwcodecs package-management"

# dropbear is a lightweight ssh server
IMAGE_FEATURES += "ssh-server-dropbear"
# IMAGE_FEATURES += "ssh-server-openssh"

# rng-tools causes excessive boot delays, though it is recommended by openssh (ssh-server-openssh)
# PACKAGE_EXCLUDE += "rng-tools"

JOCO_APPS = " "

JOCO_BSP = " "

JOCO_FONTS = " \
    fontconfig \
    fontconfig-utils \
"

JOCO_QT5_ESSENTIALS = " \
    qt5-env \
    qtbase \
    qtdeclarative \
    qtquickcontrols \
    qtquickcontrols2 \
"

# JOCO_QT5_ADD_ONS = " \
#     qtgraphicaleffects \
#     qtscript \
#     qtserialport \
#     qtsvg \
#     qtwebsockets \
#     qtxmlpatterns \
# "

# xdotool is used by applications to search window and switch focus
JOCO_EXTRA_PKGS = " \
    tzdata \
    udev-extraconf \
    umtp-responder \
    x11vnc \
    xdotool \
"

IMAGE_INSTALL += " \
    ${JOCO_APPS} \
    ${@oe.utils.conditional('DISTRO', 'poky', '', '${JOCO_BSP}', d)} \
    ${JOCO_FONTS} \
    ${JOCO_QT5_ESSENTIALS} \
    ${JOCO_EXTRA_PKGS} \
"

# rootfs post processing
IMAGE_BLACKLIST_FILES += " \
    /etc/init.d/hwclock.sh \
 "

remove_blacklist_files() {
    for i in ${IMAGE_BLACKLIST_FILES}; do
        rm -rf ${IMAGE_ROOTFS}$i
    done
}

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/America/Los_Angeles ${IMAGE_ROOTFS}/etc/localtime
}

set_locale() {
    # /etc/profile.d/locale.sh
    mkdir -p ${IMAGE_ROOTFS}/etc/profile.d/
    touch ${IMAGE_ROOTFS}/etc/profile.d/locale.sh
    echo "export LANG=en_US.UTF-8"  >> ${IMAGE_ROOTFS}/etc/profile.d/locale.sh
}

set_rootfs_version() {
    # /etc/profile.d/rootfs_version.sh
    mkdir -p ${IMAGE_ROOTFS}/etc/profile.d/
    touch ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
    echo "ROOTFS_YEAR=\`cat /etc/version | cut -c 1-4\`" >> ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
    echo "ROOTFS_MONTH=\`cat /etc/version | cut -c 5-6\`" >> ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
    echo "ROOTFS_DAY=\`cat /etc/version | cut -c 7-8\`" >> ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
    echo "echo \"***********************************************************\""  >> ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
    echo "echo \"* JOCO Yocto Linux rootfs / created on \${ROOTFS_YEAR}-\${ROOTFS_MONTH}-\${ROOTFS_DAY} *\""  >> ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
    echo "echo \"***********************************************************\""  >> ${IMAGE_ROOTFS}/etc/profile.d/rootfs_version.sh
}

ROOTFS_POSTPROCESS_COMMAND += " \
    remove_blacklist_files ; \
    set_local_timezone ; \
    set_locale ; \
    set_rootfs_version ; \
"
