SUMMARY = "Joco Dev Tools on Target"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

DEV_SDK_PKGS = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    elfutils elfutils-binutils \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gdb \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    ltrace \
    make \
    perl-modules \
    python3-modules \
"

DEV_COMMON_TOOLS = " \
    bzip2 \
    curl \
    diffutils \
    file \
    findutils \
    grep \
    less \
    nano \
    pkgconfig \
    strace \
    unzip \
    wget \
    zip \
"

DEV_EXTRA_TOOLS = " \
    dosfstools \
    e2fsprogs-mke2fs \
    fbset \
    i2c-tools \
    lsof \
    netcat-openbsd \
    nmap \
    ntp ntp-tickadj \
    parted \
    procps \
    rndaddtoentcnt \
    sysfsutils \
    util-linux \
    util-linux-blkid \
"

DEV_NET_TOOLS = " \
    ethtool \
    ifupdown \
    iperf3 \
    iproute2 \
    iptables \
    firewall \
    tcpdump \
"

IMAGE_INSTALL += " \
    ${DEV_SDK_PKGS} \
    ${DEV_COMMON_TOOLS} \
    ${DEV_EXTRA_TOOLS} \
    ${DEV_NET_TOOLS} \
"
