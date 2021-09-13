<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="DiamondFund/gem">
        <xsl:element name="Origin">
            <xsl:attribute name="place">
                <xsl:value-of select="origin"/>
            </xsl:attribute>
            <VisualParameters>
                <color>
                    <xsl:value-of select="VisualParameters/color"/>
                </color>
                <numberOfFaces>
                    <xsl:value-of select="VisualParameters/numberOfFaces"/>
                </numberOfFaces>
                <transparency>
                    <xsl:value-of select="VisualParameters/transparency"/>
                </transparency>
            </VisualParameters>
            <id>
                <xsl:value-of select="@id"/>
            </id>
            <name>
                <xsl:value-of select="name"/>
            </name>
            <preciousness>
                <xsl:value-of select="preciousness"/>
            </preciousness>
            <value>
                <xsl:value-of select="value"/>
            </value>
        </xsl:element>
    </xsl:template>

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>
