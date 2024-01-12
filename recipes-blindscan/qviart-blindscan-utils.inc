DESCRIPTION = "Utils for blindscan"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGES = "qviart-blindscan-utils-${SOC_FAMILY}"

PROVIDES += "virtual/blindscan-dvbs"
RPROVIDES:qviart-blindscan-utils-${SOC_FAMILY} += "virtual/blindscan-dvbs"

PV = "1.0"
PR = "r0"

SRC_URI = "http://en3homeftp.net/pub/down/qviart_blindscan_${SOC_FAMILY}.tar.xz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"
