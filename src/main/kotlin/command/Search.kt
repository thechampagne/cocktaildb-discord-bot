package command

import io.github.thexxiv.cocktaildb.CocktailDB
import io.github.thexxiv.jda.command.manager.Command
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import java.awt.Color
import java.time.Instant
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import kotlin.random.Random

class Search : Command {
    override fun run(args: List<String>, event: GuildMessageReceivedEvent) {
        val input = args.stream().map { obj: Any -> obj.toString() }.collect(Collectors.joining(" "))
        val user = event.message.author.name
        val icon = event.message.author.avatarUrl
        val bot = event.jda.selfUser.name
        val botIcon = event.jda.selfUser.avatarUrl
        val message = event.channel.sendMessageEmbeds(EmbedBuilder().setDescription("**Loading...** :hourglass:").setColor(Color.decode("#ffac33")).build())
            .delay(3, TimeUnit.SECONDS).complete()
        try {
            if (!indexExists(args, 0)) {
                message.editMessageEmbeds(
                    EmbedBuilder().setDescription("**You have to write a cocktail name** :warning:").setColor(Color.decode("#ffcc4d")).build()
                ).queue()
            } else {
                val data = CocktailDB.search(input)
                if (data != null) {
                    val random = Random.nextInt(data.size)
                    val drink = data[random]
                    val r = Random.nextInt(255);
                    val g = Random.nextInt(255);
                    val b = Random.nextInt(255);
                    var str = ""
                    if (drink.strDrink != null) str += "**`Drink:`** **${drink.strDrink}**\n\n"
                    if (drink.idDrink != null) str += "**`Id:`** **${drink.idDrink}**\n\n"
                    if (drink.strDrinkAlternate != null) str += "**`Drink Alternate:`** **${drink.strDrinkAlternate}**\n\n"
                    if (drink.strTags != null) str += "**`Tags:`** **${drink.strTags}**\n\n"
                    if (drink.strCategory != null) str += "**`Category:`** **${drink.strCategory}**\n\n"
                    if (drink.strIBA != null) str += "**`IBA:`** **${drink.strIBA}**\n\n"
                    if (drink.strAlcoholic != null) str += "**`Alcoholic:`** **${drink.strAlcoholic}**\n\n"
                    if (drink.strGlass != null) str += "**`Glass:`** **${drink.strGlass}**\n\n"
                    if (drink.strInstructions != null) str += "**`Instructions:`** **${drink.strInstructions}**\n\n"
                    if (drink.strInstructionsDE != null) str += "**`InstructionsDE:`** **${drink.strInstructionsDE}**\n\n"
                    if (drink.strInstructionsES != null) str += "**`InstructionsES:`** **${drink.strInstructionsES}**\n\n"
                    if (drink.strInstructionsFR != null) str += "**`InstructionsFR:`** **${drink.strInstructionsFR}**\n\n"
                    if (drink.strInstructionsIT != null) str += "**`InstructionsIT:`** **${drink.strInstructionsIT}**\n\n"
                    if (drink.strInstructionsZHHANS != null) str += "**`InstructionsZH-HANS:`** **${drink.strInstructionsZHHANS}**\n\n"
                    if (drink.strInstructionsZHHANT != null) str += "**`InstructionsZH-HANT:`** **${drink.strInstructionsZHHANT}**\n\n"
                    if (drink.strDrinkThumb != null) str += "**`Image:`** **${drink.strDrinkThumb}**\n\n"
                    if (drink.strVideo != null) str += "**`Video:`** **${drink.strVideo}**\n\n"
                    if (drink.strIngredient1 != null) str += "**`Ingredient1:`** **${drink.strIngredient1}**\n\n"
                    if (drink.strIngredient2 != null) str += "**`Ingredient2:`** **${drink.strIngredient2}**\n\n"
                    if (drink.strIngredient3 != null) str += "**`Ingredient3:`** **${drink.strIngredient3}**\n\n"
                    if (drink.strIngredient4 != null) str += "**`Ingredient4:`** **${drink.strIngredient4}**\n\n"
                    if (drink.strIngredient5 != null) str += "**`Ingredient5:`** **${drink.strIngredient5}**\n\n"
                    if (drink.strIngredient6 != null) str += "**`Ingredient6:`** **${drink.strIngredient6}**\n\n"
                    if (drink.strIngredient7 != null) str += "**`Ingredient7:`** **${drink.strIngredient7}**\n\n"
                    if (drink.strIngredient8 != null) str += "**`Ingredient8:`** **${drink.strIngredient8}**\n\n"
                    if (drink.strIngredient9 != null) str += "**`Ingredient9:`** **${drink.strIngredient9}**\n\n"
                    if (drink.strIngredient10 != null) str += "**`Ingredient10:`** **${drink.strIngredient10}**\n\n"
                    if (drink.strIngredient11 != null) str += "**`Ingredient11:`** **${drink.strIngredient11}**\n\n"
                    if (drink.strIngredient12 != null) str += "**`Ingredient12:`** **${drink.strIngredient12}**\n\n"
                    if (drink.strIngredient13 != null) str += "**`Ingredient13:`** **${drink.strIngredient13}**\n\n"
                    if (drink.strIngredient14 != null) str += "**`Ingredient14:`** **${drink.strIngredient14}**\n\n"
                    if (drink.strIngredient15 != null) str += "**`Ingredient15:`** **${drink.strIngredient15}**\n\n"
                    if (drink.strMeasure1 != null) str += "**`Measure1:`** **${drink.strMeasure1}**\n\n"
                    if (drink.strMeasure2 != null) str += "**`Measure2:`** **${drink.strMeasure2}**\n\n"
                    if (drink.strMeasure3 != null) str += "**`Measure3:`** **${drink.strMeasure3}**\n\n"
                    if (drink.strMeasure4 != null) str += "**`Measure4:`** **${drink.strMeasure4}**\n\n"
                    if (drink.strMeasure5 != null) str += "**`Measure5:`** **${drink.strMeasure5}**\n\n"
                    if (drink.strMeasure6 != null) str += "**`Measure6:`** **${drink.strMeasure6}**\n\n"
                    if (drink.strMeasure7 != null) str += "**`Measure7:`** **${drink.strMeasure7}**\n\n"
                    if (drink.strMeasure8 != null) str += "**`Measure8:`** **${drink.strMeasure8}**\n\n"
                    if (drink.strMeasure9 != null) str += "**`Measure9:`** **${drink.strMeasure9}**\n\n"
                    if (drink.strMeasure10 != null) str += "**`Measure10:`** **${drink.strMeasure10}**\n\n"
                    if (drink.strMeasure11 != null) str += "**`Measure11:`** **${drink.strMeasure11}**\n\n"
                    if (drink.strMeasure12 != null) str += "**`Measure12:`** **${drink.strMeasure12}**\n\n"
                    if (drink.strMeasure13 != null) str += "**`Measure13:`** **${drink.strMeasure13}**\n\n"
                    if (drink.strMeasure14 != null) str += "**`Measure14:`** **${drink.strMeasure14}**\n\n"
                    if (drink.strMeasure15 != null) str += "**`Measure15:`** **${drink.strMeasure15}**\n\n"
                    if (drink.strImageSource != null) str += "**`Image Source:`** **${drink.strImageSource}**\n\n"
                    if (drink.strImageAttribution != null) str += "**`Image Attribution:`** **${drink.strImageAttribution}**\n\n"
                    if (drink.strCreativeCommonsConfirmed != null) str += "**`Creative Commons Confirmed:`** **${drink.strCreativeCommonsConfirmed}**\n\n"
                    if (drink.dateModified != null) str += "**`Date Modified:`** **${drink.dateModified}**"

                    message.editMessageEmbeds(EmbedBuilder()
                        .setAuthor(bot,null,botIcon)
                        .setDescription(str)
                        .setColor(Color(r,g,b))
                        .setFooter("Requested by $user", icon)
                        .setTimestamp(Instant.now())
                        .build()).queue()
                } else {
                    message.editMessageEmbeds(
                        EmbedBuilder().setDescription("**Something went wrong** :bangbang:").setColor(Color.decode("#be1931")).build()
                    ).queue()
                }
            }
        } catch (ex: Exception) {
            message.editMessageEmbeds(
                EmbedBuilder().setDescription("**Something went wrong** :bangbang:").setColor(Color.decode("#be1931")).build()
            ).queue()
        }
    }

    override fun getCommand(): String {
        return "search"
    }
}

fun indexExists(list: List<String>, index: Int): Boolean {
    return index >= 0 && index < list.size
}