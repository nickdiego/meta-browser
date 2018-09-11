require chromium-ozone-wayland-tarball.inc
require chromium-gn.inc

SRC_URI += " \
 file://revert_base_optional/0001-Revert-Implement-converting-constructors-from-Option.patch \
 file://revert_base_optional/0002-Revert-Implement-conditional-copy-move-ctors-assign-.patch \
 file://revert_base_optional/0003-Revert-Use-affirmative-expression-in-base-Optional.patch \
 file://revert_base_optional/0004-Revert-Fix-non-copyable-class-s-optional-move.patch \
 file://revert_base_optional/0005-Revert-Implement-conditional-constexpr-copy-move-con.patch \
 file://ime-support/0001-Change-conflicting-mojo-enum-value.patch \
 file://ime-support/0002-IME-for-Mus-Linux-IME-context-servification.patch \
 file://ime-support/0003-Add-text-input-unstable-v1-protocol-to-wayland-proto.patch \
 file://ime-support/0004-Ozone-Wayland-IME-integration.patch \
 file://ime-support/0005-IME-for-Mus-Add-ui-InputMethodAuraLinux-logic-to-ime.patch \
 file://0001-ozone-wayland-Explicitly-release-capture-of-destroye.patch \
 file://0001-Fix-kiosk-and-start-maximized-modes-in-AGL.patch \
 file://0001-Use-namespace-identifier-to-avoid-mis-declaration.patch \
 file://0001-Use-constexpr-needed-for-in-class-initialization.patch \
 file://0001-Use-SK_ARM_HAS_NEON-guard-in-skia-for-float-instruct.patch;patchdir=third_party/skia \
 file://0001-Rotate-gcc-toolchain-s-build-flags.patch \ 
 file://0001-third_party-Make-it-possible-to-build-chromium-with-.patch \
"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += "\
        libxkbcommon \
        virtual/egl \
        wayland \
"

GN_ARGS += "\
        enable_mus=true \
        use_ozone=true \
        ozone_auto_platforms=false \
        ozone_platform_headless=true \
        ozone_platform_wayland=true \
        ozone_platform_x11=false \
        use_xkbcommon=true \
        use_system_libwayland=true \
"

# The chromium binary must always be started with those arguments.
CHROMIUM_EXTRA_ARGS_append = " --mus --ozone-platform=wayland"
