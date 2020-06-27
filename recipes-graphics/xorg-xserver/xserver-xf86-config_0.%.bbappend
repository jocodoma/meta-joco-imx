SUMMARY = "Add Screen Resolution for Poky"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

PR = "r1"

# use "gtf 800 480 60.0" to get the following info
do_install_append() {
    sed -i '/Modeline/a \ \ \ \ # 800x480  60.00 Hz (GTF) hsync: 29.82 kHz; pclk: 29.58 MHz' ${D}/${sysconfdir}/X11/xorg.conf
    sed -i '/# 800x480/a \ \ \ \ Modeline "800x480_60.00"    29.58   800  816  896  992  480 481 484 497 -hsync +vsync' ${D}/${sysconfdir}/X11/xorg.conf
    sed -i 's/Modes     "640x480"'/'Modes     "800x480_60.00"/' ${D}/${sysconfdir}/X11/xorg.conf
}
