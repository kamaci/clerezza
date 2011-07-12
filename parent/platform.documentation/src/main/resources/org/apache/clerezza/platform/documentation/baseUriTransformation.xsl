<?xml version="1.0" encoding="UTF-8"?>
<!--

 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.

-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:param name="baseUri"/>
	<xsl:param name="originBundleSymbolicName"/>
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="@href[parent::a]">
		<xsl:attribute name="href">
			<xsl:choose>
				<xsl:when test="starts-with(.,'bundle:///')">
					<xsl:value-of select="concat($baseUri,'bundle-doc/',$originBundleSymbolicName,substring-after(.,'bundle://'))"/>
				</xsl:when>
				<xsl:when test="starts-with(.,'bundle://')">
					<xsl:value-of select="concat($baseUri,'bundle-doc/',substring-after(.,'bundle://'))"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="."/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:attribute>
	</xsl:template>
</xsl:stylesheet>
