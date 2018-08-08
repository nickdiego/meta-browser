PACKAGECONFIG_pn-chromium-ozone-wayland =" use-egl wayland disable-api-keys-info-bar proprietary-codecs"
DEPENDS_pn-libepoxy += "libegl"

IMAGE_INSTALL_append = " chromium-ozone-wayland"

