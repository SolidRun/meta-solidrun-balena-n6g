SUMMARY = "Solidsense miscellaneous scripts"
DESCRIPTION = "Solidsense miscellaneous scripts"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = " \
    file://../gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = " \
    file://gpl-2.0.txt \
    git://github.com/SolidRun/SolidSense-V1.git;branch=V1.2.1;destsuffix=SolidSense-V1;name=SolidSense-V1 \
"
SRCREV_SolidSense-V1 = "628fa848971ded2e2ad028b2c8a1b4b49e86eadc"
S-V1 = "${WORKDIR}/SolidSense-V1"


RDEPENDS_${PN} = " \
    openocd \
"

do_install () {
    install -d ${D}/opt/scripts
    install -m 0755 ${S-V1}/ublox/flash_ublox.sh ${D}/opt/scripts/flash_ublox
}

FILES_${PN} = " \
    /opt/scripts/flash_ublox \
"

COMPATIBLE_MACHINE = "solidrun-n6g"
