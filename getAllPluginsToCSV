import jenkins.model.*
import hudson.PluginWrapper
import java.io.StringWriter

StringWriter csvWriter = new StringWriter()
csvWriter.append("Plugin Name,Version,URL,Description,Usage Area,Used in Pipelines,Status\n")

PluginManager pluginManager = Jenkins.instance.pluginManager
List<PluginWrapper> plugins = pluginManager.plugins

plugins.each { plugin ->
    String pluginName = plugin.getShortName()
    String version = plugin.getVersion()
    String url = plugin.getUrl() ?: "N/A"
    String description = plugin.getManifest()?.getMainAttributes()?.getValue("Long-Name") ?: "N/A"
    
    String usageArea = "N/A" // Usage Area
    String usedInPipelines = "N/A" // Used in Pipelines
    String status = plugin.isActive() ? "Active" : "Inactive" // Status
    
    csvWriter.append("${pluginName},${version},${url},${description},${usageArea},${usedInPipelines},${status}\n")
}

println(csvWriter.toString())
