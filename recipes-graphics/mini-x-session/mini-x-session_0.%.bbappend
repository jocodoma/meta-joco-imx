SUMMARY = "Configure mini-x-session"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

PR = "r1"

# 1) disable matchbox-terminal
# 2) turn off the title bar and cursor
do_install_append() {
    sed -i 's/matchbox-terminal/#matchbox-terminal/' ${D}/${bindir}/mini-x-session
    sed -i 's/matchbox-window-manager/matchbox-window-manager -use_titlebar no -use_cursor no/' ${D}/${bindir}/mini-x-session
}
