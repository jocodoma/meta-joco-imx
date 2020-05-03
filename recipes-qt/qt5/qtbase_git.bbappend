SUMMARY = "Configurations for Qt5"
MAINTAINER = "Joseph Chen <jocodoma@gmail.com>"

# Enable features
PACKAGECONFIG += "eglfs gles2 sql-sqlite icu"

# Following features are enabled by default:
# "accessibility dbus udev evdev widgets tools libs freetype test"
# for more info: meta-qt5/recipes-qt/qt5/qtbase_git.bb

# Remove features
#PACKAGECONFIG_DEFAULT_remove = "tests"

# tslib
#PACKAGECONFIG_append = " tslib"
