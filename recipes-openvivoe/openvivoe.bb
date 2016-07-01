#
# This is the recipe to build OpenVivoe, the Open Source
# implementation of the VIVOE standard.
#

SUMMARY = "OpenVivoe is the Open Source implementation of the VIVOE standard"
SECTION = "base"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

S = "${WORKDIR}/git"

SRCREV = "94df2c30dc0f2bd9deaa31b1306764a484114249"

PR = "r6"
PV = "git${SRCPV}"

SRC_URI = "git://github.com/Openwide-Ingenierie/openvivoe.git"

DEPENDS = "glib-2.0 gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad net-snmp"

inherit cmake
