DESCRIPTION = "Linux kernel for ${MACHINE}"
LICENSE = "GPL-2.0-only"
SECTION = "kernel"
KV = "4.1.20"
PR_INC = ".2"

SRC_URI[md5sum] = "710b7af46d7ac1c78e3ef683c5c0a6ad"
SRC_URI[sha256sum] = "1bb6b4f0d559885b3bd5f18c66a50a8ff39a284a81ad4da16188d08b9461ec55"

LIC_FILES_CHKSUM = "file://${WORKDIR}/linux/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

FILESEXTRAPATHS:prepend := "${THISDIR}/stblinux-${KV}:"

DATETIME = "20180321"

SRC_URI = "http://en3homeftp.net/pub/down/linux-${KV}-${DATETIME}.tar.xz \
        file://defconfig \
	file://0002-log2-give-up-on-gcc-constant-optimizations.patch \
	file://0003-dont-mark-register-as-const.patch \
	file://make-yyloc-declaration-extern.patch \
        "

inherit kernel machine_kernel_pr

S = "${WORKDIR}/linux"

export OS = "Linux"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/${KERNEL_IMAGETYPE}"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"

FILES:${KERNEL_PACKAGE_NAME}-image = "/${KERNEL_IMAGEDEST}/zImage"

do_configure:prepend() {
}

kernel_do_install:append() {
        install -d ${D}/${KERNEL_IMAGEDEST}
        install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
}

kernel_do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
        oe_runmake ${KERNEL_IMAGETYPE_FOR_MAKE} ${KERNEL_ALT_IMAGETYPE} CC="${KERNEL_CC}" LD="${KERNEL_LD}"
}

pkg_postinst:kernel-image () {
        if [ -d /proc/stb ] ; then
                dd if=/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} of=/dev/mmcblk0p1
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
        true
}

pkg_postrm:kernel-image () {
}

MACHINE_KERNEL_PR:append = "${PR_INC}.0"

COMPATIBLE_MACHINE = "^(lunix4k)"
