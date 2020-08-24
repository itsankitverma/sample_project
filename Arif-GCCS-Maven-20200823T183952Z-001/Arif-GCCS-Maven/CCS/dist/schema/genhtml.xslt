<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xsl:template match="/">
        <html>
            <head />
            <body>
                <xsl:for-each select="receivableList">
                    <xsl:for-each select="receivable">
                        <xsl:if test="position()=1">
                            <table border="1">
                                <thead>
                                    <tr>
                                        <td>num</td>
                                        <td>location</td>
                                        <td>mtn</td>
                                        <td>customer</td>
                                        <td>recDate</td>
                                        <td>recNumber</td>
                                        <td>recCurrency</td>
                                        <td>exchRate</td>
                                        <td>recAmount</td>
                                        <td>rodAmount</td>
                                        <td>anchargeAmount</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <xsl:for-each select="../receivable">
                                        <tr>
                                            <td>
                                                <xsl:for-each select="@num">
                                                    <xsl:value-of select="." />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="location">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="mtn">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="customer">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="recDate">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="recNumber">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="recCurrency">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="exchRate">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="recAmount">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="rodAmount">
                                                    <xsl:apply-templates />
                                                </xsl:for-each>
                                            </td>
                                            <td>
                                                <xsl:for-each select="anchargeAmount">
                                                    <span style="position:relative; ">
                                                        <xsl:apply-templates />
                                                    </span>
                                                </xsl:for-each>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                </tbody>
                            </table>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
