SUMMARY = "grab for dags Model ${MACHINE_ARCH}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(dual)$"

SRCDATE = "20211031"

PV = "${SRCDATE}"
PR = "r0"

RPROVIDES_${PN}  = "aio-grab"
RREPLACES_${PN}  = "aio-grab"
RCONFLICTS_${PN} = "aio-grab"

SRC_URI = "http://downloads.openpli.org/archive/qviart/${MACHINE}-grab-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/grab ${D}/${bindir}
}

do_package_qa() {
}

FILES_${PN}  = "${bindir}/grab"

SRC_URI[md5sum] = "8adc85fe14b79f296fc7f0f1376e193e"
SRC_URI[sha256sum] = "6979e6f2729a6c6748c48bf0eb7cf9ce35a7122a480981b072e9e7c9c3e297ef"
