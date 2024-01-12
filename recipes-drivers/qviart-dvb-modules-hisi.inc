SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "${KV}+${SRCDATE}"
PR = "r1"

SRC_URI = "http://en3homeftp.net/pub/down/${MACHINE}-hiko-${SRCDATE}.tar.gz \
	file://modules"

S = "${WORKDIR}/lib/modules/${KV}/extra"

INHIBIT_PACKAGE_STRIP = "1"

FILES:${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"
FILES:${PN} += "/lib/modules/${KV}/extra"

do_compile() {
}
do_populate_sysroot() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/lib/modules/${KV}/extra/sata
    install -d ${D}/lib/modules/${KV}/extra/usb
    install -m 0644 ${S}/*.ko ${D}/lib/modules/${KV}/extra
    install -m 0755  ${S}/load ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    install -m 0644 ${WORKDIR}/modules ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
}
