SUMMARY = "Joco x11 Release Image"
HOMEPAGE = "https://about.jocodoma.com/"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

require core-image-joco-x11-base.bb

# Remove "debug-tweaks" for final release image
#EXTRA_IMAGE_FEATURES_remove = "debug-tweaks"

# Add password to protect login for release image
# The default password for root is set to "joco1234"
#inherit extrausers
#EXTRA_USERS_PARAMS = "usermod -P joco1234 root;"

# To allow root to login from SSH
#set_allow_root_ssh() {
#    # /etc/ssh/sshd_config
#    echo "PermitRootLogin yes" >> ${IMAGE_ROOTFS}/etc/ssh/sshd_config
#}

#ROOTFS_POSTPROCESS_COMMAND += " \
#    set_allow_root_ssh ; \
#"
