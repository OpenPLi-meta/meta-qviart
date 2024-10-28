SUMMARY = "grab for dags Model ${MACHINEBUILD}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(lunix4k|lunix3-4k)$"

SRCDATE = "20211104"

PV = "${SRCDATE}"
PR = "r0"

RPROVIDES:${PN}  = "aio-grab"
RREPLACES:${PN}  = "aio-grab"
RCONFLICTS:${PN} = "aio-grab"

SRC_URI = "http://downloads.openpli.org/archive/qviart/${MACHINE}-grab-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/grab ${D}/${bindir}
}

do_package_qa() {
}

FILES:${PN}  = "${bindir}/grab"

SRC_URI[md5sum] = "a5439bff89718b6b3477a38bf328a4be"
SRC_URI[sha256sum] = "1da46493c92dbedde9aad1486418108dc898d85802bbdc0003c635145b2ecdaa"
