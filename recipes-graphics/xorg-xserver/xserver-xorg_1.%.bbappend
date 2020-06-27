SUMMARY = "Remove xf86-input and libinput"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

PR = "r1"

# xinput-calibrator-once expects an evdev interface, so don't install
# xf86-input-libinput which takes precedence over xf86-input-evdev
# but it's needed for qemu, so keep it for Poky distro
XSERVER_RRECOMMENDS_remove = " \
    ${@oe.utils.conditional('DISTRO', 'poky', '', 'xkeyboard-config xf86-input-libinput', d)} \
"
