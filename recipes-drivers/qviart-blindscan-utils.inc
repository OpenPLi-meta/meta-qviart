DESCRIPTION = "Utils for blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

PACKAGES = "qviart-blindscan-utils-${CHIP}"

PROVIDES += "virtual/blindscan-dvbs"
RPROVIDES:qviart-blindscan-utils-${CHIP} += "virtual-blindscan-dvbs"

PV = "1.0"
PR = "r0"

#SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-blindscan-utils-${PV}.tar.bz2"
SRC_URI = "http://en3homeftp.net/pub/down/qviart_blindscan_${CHIP}.tar.xz"

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

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH := "${MACHINE_ARCH}"

