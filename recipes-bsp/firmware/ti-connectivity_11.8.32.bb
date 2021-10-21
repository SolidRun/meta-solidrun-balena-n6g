SUMMARY = "TI Connectivity firmware for bluetooth for WiLink8"
DESCRIPTION = "Provides firmware required by SolidRun i.MX6 based SOMs."
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f39eac9f4573be5b012e8313831e72a9"
SRC_URI = " \
    git://git.ti.com/ti-bt/service-packs.git \
"
SRCREV = "6c9104f0fb7ca1bfb663c61e9ea599b3eafbee67"
S = "${WORKDIR}/git"

do_compile () {
}

do_install () {
    install -d ${D}${base_libdir}/firmware/ti-connectivity

    install -m 0644 ${S}/initscripts/TIInit_${PV}.bts ${D}${base_libdir}/firmware/ti-connectivity
}

FILES_${PN} = "${base_libdir}/firmware/ti-connectivity/*"

COMPATIBLE_MACHINE = "solidrun-n6g"
