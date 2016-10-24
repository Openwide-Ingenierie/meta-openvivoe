#
# This is the recipe to build OpenVivoe, the Open Source
# implementation of the VIVOE standard.
#

SUMMARY = "OpenVivoe is the Open Source implementation of the VIVOE standard"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
HOMEPAGE = "https://openwide-ingenierie.github.io/openvivoe/"
SECTION = "multimedia"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "1.0"

SRC_URI = "git://github.com/Openwide-Ingenierie/openvivoe.git"

DEPENDS = "glib-2.0 gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad net-snmp"

RDEPENDS_${PN}+="net-snmp-server gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"

inherit cmake

CONFFILES_${PN} += "${sysconfdir}/openvivoe/vivoe-mib.conf \
                    ${sysconfdir}/openvivoe/vivoe-stream.conf \
"
FILES_${PN} += "${datadir}/snmp/mibs/VIVOE-MIB"
