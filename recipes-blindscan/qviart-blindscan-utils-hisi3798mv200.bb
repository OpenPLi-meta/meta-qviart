require qviart-blindscan-utils.inc

do_install() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/qviart_blindscan_${SOC_FAMILY}" "${D}/${bindir}/qviart_blindscan"
}

FILES:${PN} = "${bindir}/qviart_blindscan"

SRC_URI[md5sum] = "2c5c102ee2428b7a479bbc8d248e3cc4"
SRC_URI[sha256sum] = "7d807a2ed397e110f3d8ed58bd94644be977c3609d4e4ce277e295be08fc67b2"
