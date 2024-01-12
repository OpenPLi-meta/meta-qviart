require qviart-blindscan-utils.inc

do_install() {
	install -d "${D}/${bindir}"
	install -m 0755 "${S}/qviart_blindscan_72604" "${D}/${bindir}/"
}

FILES:vuplus-blindscan-dvbs-utils-${MACHINE} = "\
	${bindir}/qviart_blindscan_72604 \
"
