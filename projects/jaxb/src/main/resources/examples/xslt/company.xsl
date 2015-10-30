<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Company Information</h2>
                <p>
                    <b>Name:</b> <xsl:value-of select="company/name"/>
                </p>
                <b>Employees</b>
                <table>
                    <xsl:for-each select="company/employees/employee">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="age"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>