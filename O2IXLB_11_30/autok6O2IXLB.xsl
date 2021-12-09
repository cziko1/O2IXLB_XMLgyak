<?xml version = "1.0" encoding = "UTF-8"?> 
   <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
<xsl:template match = "/">   
    <html>
        <body>
            <h2>Cars</h2>
            <table border = "1">
                <tr bgcolor = "#F6358A">
                    <th>rsz</th>
                    <th>tipus</th>
                    <th>ar</th>
                    <th>szin</th>
                    <th>nev</th>
                    <th>varos</th>
                </tr>

                <xsl:for-each select = "/autok/auto">
                <tr>
                    <td><xsl:value-of select = "nev"/></td>
                </tr>
            </xsl:for-each> 

            </table>
        </body>
    </html>


</xsl:template>  
</xsl:stylesheet>