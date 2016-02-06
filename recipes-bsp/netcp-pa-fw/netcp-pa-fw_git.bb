DESCRIPTION = "NETCP PA firmware for Keystone"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENCE.ti-keystone;md5=3a86335d32864b0bef996bee26cc0f2c"

PV = "1.0.0"
PR = "r0"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "k2hk-evm|k2l-evm|k2e-evm"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV = "55c708e391c5663a9ef0bb13970f2153f82fba36"
BRANCH ?= "ti-linux-firmware-4.1.y"

SRC_URI = "git://git.ti.com/processor-firmware/ti-linux-firmware.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

FWBASENAME = " \
ks2_pa_eg0_pdsp0 \
ks2_pa_eg0_pdsp1 \
ks2_pa_eg0_pdsp2 \
ks2_pa_eg1_pdsp0 \
ks2_pa_eg2_pdsp0 \
ks2_pa_in0_pdsp0 \
ks2_pa_in0_pdsp1 \
ks2_pa_in1_pdsp0 \
ks2_pa_in1_pdsp1 \
ks2_pa_in2_pdsp0 \
ks2_pa_in3_pdsp0 \
ks2_pa_in4_pdsp0 \
ks2_pa_in4_pdsp1 \
ks2_pa_post_pdsp0 \
ks2_pa_post_pdsp1 \
"

FWBASENAME_k2hk-evm = " \
ks2_pa_pdsp0_classify1 \
ks2_pa_pdsp1_classify1 \
ks2_pa_pdsp2_classify1 \
ks2_pa_pdsp3_classify2 \
ks2_pa_pdsp4_pam \
ks2_pa_pdsp5_pam \
"

do_install() {
	install -d ${D}${base_libdir}/firmware
	for f in ${FWBASENAME}; do
		install -m 0644 ${S}/ti-keystone/$f-${PV}.bin ${D}${base_libdir}/firmware/$f.bin
	done
}

FILES_${PN} = "${base_libdir}/firmware"