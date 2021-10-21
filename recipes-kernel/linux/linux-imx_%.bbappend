inherit kernel-resin
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-imx:"

SRC_URI += " \
    file://0001-update-dts-for-solidsense.patch \
    file://0002-update-BUSFREQ-compile-option.patch \
    file://0003-update-arch-arm-boot-dts-imx6qdl-sr-som-ti-dtsi.patch \
"
COMPATIBLE_MACHINE = "solidrun-n6g"
