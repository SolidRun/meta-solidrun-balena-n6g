# Copyright (C) 2012-2018 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

require recipes-bsp/u-boot/u-boot.inc
UBOOT_KCONFIG_SUPPORT = "1"
#BALENA_UBOOT_DEVICE_TYPES="usb mmc"
inherit resin-u-boot

PROVIDES += "u-boot"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
#SRC_URI_remove = " \
#    file://resin-specific-env-integration-kconfig.patch \
#"
#    git://github.com/solidrun-ejb/u-boot.git;branch=${SRCBRANCH} \
#
SRC_URI = " \
    git://github.com/u-boot/u-boot.git \
    file://0001-Integrate-Resin-u-boot-enivroment.patch \
    file://0002-mx6cuboxi-update-ENV-size-pos-and-add-fat-options.patch \
"

DEPENDS = " \
    bison-native \
    kern-tools-native \
"

SRCREV = "0b0c6af38738f2c132cfd41a240889acaa031c8f"
#SRCBRANCH = "v2020.01-solidsense-imx6"

PV = "v2020.01-solidsense-imx6+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|solidrun-n6g)"
