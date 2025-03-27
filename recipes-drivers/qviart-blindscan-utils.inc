DESCRIPTION = "Utils for blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGES = "qviart-blindscan-utils-${CHIP} ${PN}-dbg"

PROVIDES += "virtual/blindscan-dvbs"
RPROVIDES:qviart-blindscan-utils-${CHIP} += "virtual-blindscan-dvbs"

PV = "1.0"
PR = "r0"

SRC_URI = "http://downloads.openpli.org/archive/qviart/qviart_blindscan_${CHIP}.tar.xz"

SRC_URI[md5sum] = "79a280ce1283044103585023bb365d0b"
SRC_URI[sha256sum] = "96324670f24ebbc530b849b95b17a05db4b409629af780eb085024f3d0807f49"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/qviart_blindscan_${CHIP} ${D}/${bindir}
}

FILES:${PN}-utils-${CHIP} = " \
	${bindir}/qviart_blindscan_${CHIP} \
"
FILES:${PN}-dbg-${CHIP} = "${bindir}/.debug/"

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH := "${MACHINE_ARCH}"

INSANE_SKIP = "32bit-time ldflags"
