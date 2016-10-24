DESCRIPTION = "An image containing an OpenVivoe server that will \
	broadcast test patterns on the network."

IMAGE_FEATURES += "ssh-server-openssh package-management "

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-full-cmdline \
    openvivoe \
    bash \
    "
inherit core-image 

SRC_URI="file://snmp.conf \
         file://snmpd.conf \
         file://vivoe-mib.conf \
         file://vivoe-stream.conf \
"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

#unset do_fetch[noexec]
#unset do_unpack[noexec]
python () {
   d.delVarFlag("do_fetch","noexec")
   d.delVarFlag("do_unpack","noexec")
}

install_extra_files() {
  install ${WORKDIR}/snmpd.conf ${IMAGE_ROOTFS}/etc/snmp/
  install ${WORKDIR}/snmp.conf ${IMAGE_ROOTFS}/etc/snmp/
  install ${WORKDIR}/vivoe-mib.conf ${IMAGE_ROOTFS}/etc/openvivoe/
  install ${WORKDIR}/vivoe-stream.conf ${IMAGE_ROOTFS}/etc/openvivoe/
}

IMAGE_PREPROCESS_COMMAND += "install_extra_files"
