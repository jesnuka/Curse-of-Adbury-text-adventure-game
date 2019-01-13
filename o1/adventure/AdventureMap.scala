package o1.adventure

import scala.collection.mutable.Map
import scala.collection.generic.Sorted
import scala.collection.mutable.Buffer

object LoadAreas {
  def apply(): Map[String, Area] = {
    val areas = Map[String, Area]()

    def addArea(area: Area) = {
      if (areas.contains(area.name)) {
        throw new KeyExistsException
      }
      areas += area.name -> area
    }

    addArea(Area("adbury gates", "The gates of Adbury", "You are standing on a muddy road. It's currently raining heavily with the ever so distant thunder. The moonlight and the occasional lanterns on the stone wall are lighting your surroundings.\nNorth of you stands a grand iron gate. Above it reads \"ADBURY\", in dark rusted letters made of iron.\nIn other directions you see an uninviting dark forest. "))
    addArea(Area("adbury gates inside", "Past the gates of Adbury", "You are standing on a dark brick road past the gates. The houses around you have are made of dark wood with black tiled roofs. Crows stand on the rooftops. You get the feeling as if the town itself was deceased.\nNorth of you looms the center of the town of Adbury.\nTo west you see a worn down house with a sign saying \"Gregory's Tavern\".\nTo the east there are wooden houses that have seen their better days. None of them have lights on.\nTo the south of you see the main gate to the Town. "))
    addArea(Area("market square south", "Southern part of the town quare ", "You are in the southern part of the town square.\nIn the middle of the square stands an oddly terrifying fountain depicting a man covering in fear. It seems to not be working.\nGoing north gets you to the other side of the town square.\nTo the west you see a rundown house with a sign \" General store\". A foul smell is coming from it's direction.\nTo the east you see a set of houses along a muddy brickroad. A nearby sign towards east has \"Lighthouse\" written on it, pointing east.\nTo the south you see a more buildings along a muddy brickroad going towards the main gate."))
    addArea(Area("market square north", "Northern part of the town square", "You are in the northern part of the town square. \nIn the middle of the square stands a fountain.\nGoing south gets you to the other side of the town square. \nTo the west you see two story houses along a brickroad that seems to curve north.\nNorth of you stands a tall house which unlike many others nearby, has a stone base. It has a double wooden door. The few windows you see seem to be boarded shut from the inside. \nTo the east you see a houses along a muddy brickroad that seems to curve north, where almost immediately after the square looms an ominous looking church."))
    addArea(Area("living quarters first", "Start of the brickroad curving northeast", "Around you are tall two story houses. Only a few seem to have lights on.\nThe brickroad continues north.\nTo the south you see the brickroad curve towards the town square."))
    addArea(Area("living quarters second", "End of the brickroad curving northeast", "Around you are tall two story houses. Only a few seem to have lights on.\nThe brickroad continues east, in the distance you see a tall church.\nOne of the houses to the west of you seems to have it's door slightly ajar. The lights don't seem to be on in that certain house..\nTo the south you see the brickroad curve towards the town square."))
    addArea(Area("church street first", "Start of the brickroad going past the church", "You are standing outsides the gate going to the church.\nTo the east is the gate, slightly ajar. \nTwo horned angel statues are carved on the pillars next to the gate. They are covered in moss and dirt.\nTo the north you see more houses along the brickroad that curves northwest.\nTo the south you see the brickroad curve towards the town square. "))
    addArea(Area("church street second", "End of the brickroad going past the church", "You are on a brickroad between tall houses and the stone wall surrounding the church.\nTo the north you see the brickroad curve northeast where you see many two story buildings.\nTo the west is an alleyway covered in dirt. It seems to go behind the stone based house in the town square.\nTo the south you see the brickroad going past the church's gate."))
    addArea(Area("warehouse alleyway", "Dark alleyway", "You are standing in a dark alleyway surrounded by tall walls. \nAs the rooftops cover the moonlight, your only light source is a single lantern on the wall. \nThe flame flickers around showing few barrels and crates along the walls. \nThe house with the stone base has a big window facing you that seems to have been broken. \nThe alleyway seems to end here.\nTo the east you see the alleyway lead towards a brickroad lit by the moonlight."))
    addArea(Area("church doorstep", "Just outside the church door", "You are standing just outside the door going inside the church. \nTo the east is it's door which is surrounded by a vine covered mural. \nTo the north is a gravel road going towards the graveyard. \nTo the west you see the gate leading out of the church's land, towards the main brickroad."))

    addArea(Area("park road", "Brickroad near park entrance", "You are standing on a muddy brickroad that has a few old houses built along it.\nTo the west you see the brickroad continue towards the town square.\nSouth of you is a cracked stone stairway going towards an area covered in grass and trees, which seems to be a park.\nTo the east you see the brickroad continue towards an area with some fog. "))
    addArea(Area("park", "The park", "You are standing on wet, muddy grass. It seems as if there once was a gravel road here, but it has been buried under a thick layer of grass.\nThe dark, spikey trees around you seem to be dying, which is odd considering it's constantly raining this time of the year.\nTo the north you see the cracked stone stairway.\nEast of you is a steep hill. The bottom of it is revealing the bedrock that's under the town. There is a wooden door on the bedrock wall.\n"))
    addArea(Area("cave outside", "Outside the cave in the park", "You are standing in front of the wooden door that has been built on the bedrock wall. \nThere are wooden pillars around the door. \nWest of you is the park. \nEast of you is the door."))
    addArea(Area("lighthouse street", "Brickroad near cliffside", "You are standing on a brickroad that has a few old, broken houses built along it. The area is covered in some fog. The wind carries a faint smell of the sea.\nEast of you the brickroad curves north, going up a hill. The rain and heavy fog make it hard to see far ahead but you're certain there is a steep drop if you were to continue too far past the brickroad.\nYou can't tell what's up the hill from here.\nTo the west you can just barely tell the brickroad continues towards an area with more houses along it."))
    addArea(Area("lighthouse hill 1", "Gravel road going  up a steep hill", "You are standing on a gravel road that seems to curve along a steep hill made of bedrock and dirt. The area is quite foggy. The wind carries the smell of the sea.\nTo the south you can just barely tell that the gravel road curves west, connecting to a brickroad.\nThe gravel road continues north, curving alongside the hill."))
    addArea(Area("lighthouse hill 2", "Gravel road going up a steep hill", "You are standing on a gravel road that seems to curve along a steep hill made of bedrock and dirt. The area is very foggy. The wind carries a strong smell of the sea.\nThe gravel road continues north and south, but you can't tell what's in either direction.\nYou can tell by the steep drop that you are getting quite high up the hill."))
    addArea(Area("lighthouse hill 3", "End of the gravel road", "You are standing on a gravel road on top of the hill. The gravel road stops here. The area is covered in thick fog. The wind carries a strong smell of the sea.\nYou can see that the gravel road goes south down the hill, but you can't see further than that.\nDespite the thick layer of fog, you can tell that there are two paths made out of crudely carved stone slabs here, one going west and the other north. "))
    addArea(Area("lighthouse door", "Outside the lighthouse", "You are standing outside a big lighthouse made out of dark stone bricks. You can't tell how tall the lighthouse is because of the fog. The stone slab path ends here.\nThe bottom of the wall is covered in moss and the bricks seem to be very old. The area is covered in thick fog. The wind carries a strong smell of the sea.\nNorth of you there is a rusted metallic door going inside the lighthouse. The door seems to be slightly ajar.\nDespite the thick layer of fog, you can tell that the stone slab path goes east."))
    addArea(new Area("lighthouse first", "First floor of the lighthouse.", Buffer("You are standing inside the lighthouse at the entrance. The air smells of dust and oil. Your lantern's flickering flame reveals furniture around the room. \nThere is an old, dusty looking bed next to one wall. Doesn't seem like anyone has used it in a long time. \nOn one side of the wall there is a crudely built wooden desk.\nOne side of the wall has barrels and crates stacked on top of each other. Some of them have a faint smell of rotten fish, which makes you not want to open them. \nThere is a stone stairway going up. \nUnder the staircase seems to be a rusty metal trapdoor. It won't budge. \nThe entrance to the lighthouse is to the south.")) {
      override def arrive(direction: String, adventure: Adventure): String = {
        if (adventure.player.inventory.contains("lantern") && adventure.player.inventory("lantern").descriptionIndex == 1) {
          adventure.player.location = this
          s"You go ${direction}\n" + adventure.player.look
        } else {
          "It's too dark to go inside the lighthouse without a lantern!"
        }
      }
    })
    addArea(Area("lighthouse second", "Second floor of the lighthouse", "You are standing on the second floor of the lighthouse. The air smells of dust and oil.\nThere is a bookcase on one side of the wall with a few books in it. Some of the books are slightly sticking out.\nThere are odd dust covered paintings of people on hanging on the walls. Their facial features are drawn in wrong proportions, as if the painter forgot how faces looked like.\nThe staircase goes around the wall. It leads both up and down. "))
    addArea(Area("lighthouse third", "Third floor of the lighthouse", "You are standing on the third floor of the lighthouse. The air smells of dust and oil.\nThe only thing in the room is the staircase. It goes up and down."))
    addArea(Area("lighthouse fourth", "Fourth floor of the lighthouse", "You are standing on the fourth floor of the lighthouse. The air smells of dust and oil. You can hear the raindrops hitting the roof.\nThe only thing in the room is the staircase. It goes up and down."))
    addArea(Area("lighthouse top", "Top of the lighthouse", "You are standing on the top floor of the lighthouse. In the middle is a contraption of some sort that seems to have been the source for the light. It looks like it has been broken on purpos.\nThe rain is hitting the thick glass walls around you. You can't see far outside because of the thick fog, but you can tell that the sea is north of you.\nYou get an eerie feeling when you stare towards the sea.\nThe staircase goes down."))
    addArea(Area("stone path end", "Near the cliffside towards the sea", "You are standing at the end of the stone path. The strong wind carries the smell of the sea.\nDespite the thick fog, you can tell that the rocky cliffside has a steep drop. You can hear the crashing of waves.\nDespite the thick layer of fog, you can tell that the stone slab path goes south.\nNorth of you connected to the end of the cliffside is a sturdy wooden stairway going down towards the sea."))
    addArea(Area("pier", "The pier", Buffer("You are standing on a rickety pier that has been built next to the cliffside, near the waterfront.\nDespite the storm, the pier is high enough for the waves not to go over it.\nThe fog is less thick down here, but there is still some left.\nYou can see a huge cavern entrance in the cliffside, but it's unreachable without a boat.\nYou get an eerie feeling when you stare towards the fog covered sea.\nSouth of you, the pier connects to a wooden stairway that goes up the cliffside.\nThere is a rope tied here. It seems loose enough for you to be able to untie it.", "You are standing on a rickety pier that has been built next to the cliffside, near the waterfront.\nDespite the storm, the pier is high enough for the waves not to go over it.\nThe fog is less thick down here, but there is still some left.\nYou can see a huge cavern entrance in the cliffside, but it's unreachable without a boat.\nYou get an eerie feeling when you stare towards the fog covered sea.\nSouth of you, the pier connects to a wooden stairway that goes up the cliffside.")))

    addArea(Area("tavern", "Gregory's tavern", "You are standing inside the tavern at the entrace. As soon as you entered, all the murmur inside stopped. \nIt feels as if everyone inside is staring you down. \nAround you are dark wooden tables. Some of them have raggedy looking people sitting at them, drinking murky drinks. \nThe air inside smells like a mix of whiskey and old wood, with a hint of sweat. \nThe bar counter is to the west of you. \nThe exit is to the east of you."))
    addArea(Area("tavern counter", "Gregory's tavern bar counter", "You are sitting on a rickety wooden stool at the bar counter.\nOn each end of the counter is a grumpy looking man drinking something dark. They don't seem like they want to talk.\nBehind the counter is a burly looking man with a bushy beard cleaning glasses. He is presumably Gregory, the owner of the tavern.\nThe tavern's exit is towards east. "))
    addArea(Area("general store porch", "The general store's porch", "You are standing on the porch of the general store. There are barrels near the wall that smell of rotten fish.\nThe windows have been boarded up and the door has a sign on it saying \"CLOSED\".\nThere still seems to be light coming from inside, but the door is locked.\nTo the east of you is the market square."))
    addArea(Area("cave entrance", "The entrance of the cave", "You are standing in the opening of a small cave. \nThe moonlight from the opened door shines on the cave walls.\nNear the wall, there is a hole on the ground that seems to have a metal ladder going downwards. You feel a warm breeze lift from the hole. \nA strange smells hits your nose. You can't quite tell what it is. \nThe cave exit is to the west of you. \nThe ladder goes down."))

    addArea(Area("warehouse", "The upstairs of the warehouse", "You are on the upper floor of the warehouse. The air smells of dust.\nThe room is lit by moonlight coming through some windows, revealing that the it's filled with crates and barrels.\nThe path towards the rest of the warehouse is blocked by the crates and the barrels. \nThere is an antique lamp on the floor.\nYou don't see anything useful around here.\nThe rope is hanging from the window north of you. "))
    addArea(Area("church inside", "Entrance of the church", "You are standing in the entryway of the church. Before you is a big hall filled with rows of chairs. The smell of incense reaches your nose.\nAt the end of the hall is a platform with an altar that has been decorated with roses and candles.\nOn the end wall there is a huge stained glass window depicting various sea related miracles.\nThe hall continues east towards the altar.\nThe exit is to the west of you.\nThere is a door north of you. "))
    addArea(Area("church altar", "Next to the altar", "You are standing in front of the altar.\nThe hall goes towards the exit to the west of you."))
    addArea(Area("church basement up", "Upstairs of the church basement", "You are standing at the end of stairway that seems to go down to a basement.\nThe stairway is lit by candles on the walls.\nSouth of you is the door to the church hall."))
    addArea(Area("church basement down 1", "Church basement first area", "You are standing in a dimly lit stone hallway.\nThe air smells stuffy and the dust makes it hard to breathe.\nAround you are coffins. Some of them are open and seem to be empty. The complete silence gives you chills.\nThe stone hallway continues east past a corner.\nThe stone stairway here goes up. "))
    addArea(Area("church basement down 2", "Church basement second area", "You are standing at the end of a dimly lit stone hallway.\nThe air smells stuffy and the dust makes it hard to breathe.\nAround you are coffins. Some of them are open and seem to be empty.\nThe end of the hallway contains stacks of crates.\nThe complete silence gives you chills.\nThe stone hallway goes back towards west."))

    addArea(Area("old house", "Inside the empty house at the entrance", "You are standing in the entryway of a rundown house. The furniture has been tossed around and there are papers scattered everywhere.\nIt looks like someone was searching for something.\nTo the north of you is the kitchen.\nTo the west of you is the bedroom door, which is slightly ajar."))
    addArea(Area("old house bedroom", "The bedroom of the empty house", Buffer("You are standing in the bedroom of the rundown house. The room is a mess. Papers and furniture have been scattered around, the bedsheets have been thrown on the floor and a painting has been ripped in half.\nThere is a rug weirdly placed on the floor.\nThe doorway away from the room is to the east. ", "You are standing in the bedroom of the rundown house. The room is a mess. Papers and furniture have been scattered around, the bedsheets have been thrown on the floor and a painting has been ripped in half.\nThere rug has been moved. \nThere is a trapdoor going downwards.\nThe doorway away from the room is to the east. ")))
    addArea(Area("old house kitchen", "The kitchen of the empty house", "You are standing in the kitchen of the rundown house. The smell of rotten food hits your nose.\nAll the cupboards have been left open and some dishes and tableware have been throw around the room.\nThe kitchen table has various objects on it.\nThe doorway away from the room is to the south."))
    addArea(Area("old house basement", "The hidden basement of the empty house", Buffer("You are in a crawlspace under the house. \nThere is a makeshift bed here. Around you are old clothes and food supplies scattered around. \nThere are some notes scattered around next to the bed. \nAbove you is the trapdoor to the bedroom. \nA single page that looks quite old catches your eye.", "You are in a crawlspace under the house. \nThere is a makeshift bed here. Around you are old clothes and food supplies scattered around. \nThere are some notes scattered around next to the bed. \nAbove you is the trapdoor to the bedroom.")))
    addArea(Area("forest", "Unaccessible Forest", "You don't want to give up your investigation so soon."))
    //Cave, end game area starts here.
    addArea(Area("caveladder1", "You are climbing on the ladder", "You hold tightly on the rusty metal ladder. \nYou can't see how far down the ladder goes, as it's too dark below you. \nA breeze of wind is carrying a strange smell from below. \nThe ladder continues down as well as up."))
    addArea(Area("caveladder2", "You are climbing on the ladder", "You hold tightly on the rusty metal ladder. \nYou can't see how far down the ladder goes, as it's too dark below you. \nThe warm air is making you sweat. \nA breeze of wind is carrying a strange smell from below. \nThe ladder continues down as well as up."))
    addArea(Area("caveladder3", "You are climbing on the ladder", "You hold tightly on the rusty metal ladder. \nYou can't see how far down the ladder goes, as it's too dark below you. \nThe warm air is making you sweat. \nA breeze of wind is carrying a strange smell from below. You have a slight headache. \nIt's quite dark which makes it hard to see upwards from this point.\nThe ladder continues down as well as up."))
    addArea(Area("caveladder4", "You are climbing on the ladder", "You hold tightly on the rusty metal ladder. \nYou can't see how far down the ladder goes, as it's too dark below you. \nThe warm air is making you sweat. \nA breeze of wind is carrying a strange smell from below. You have a strong headache. \nIt's almost pitch black. \nYou can't really tell if the ladder even goes upwards anymore.\nThe ladder continues down."))
    addArea(Area("caveladder5", "You are climbing on the ladder", "You hold tightly on the rusty metal ladder. You are sweating quite profusely. \nThe walls around you feel like they are closing in. It's pitch black. Your headache is getting stronger.\nThe ladder seems to go down."))
    addArea(Area("caveladder6", "You are climbing on the ladder", "You hold very tightly on the rusty metal ladder. You are drenched in sweat. \nIt feels as if the world is spinning. \nYour racing heart and massive headache make it hard to think straight. \nIt feels as if something else is telling you to let go and fall.\nThe ladder seems to go down."))
    addArea(Area("caveladder7", "You are climbing on the ladder", "You are holding on the rusty metal ladder with all your might. Your delirious state obstructs all your senses. \nIt feels as if something is ordering you to let go of the ladder. Perhaps doing so would relieve your state.\nThe ladder seems to go down. "))
    addArea(Area("caveladder8", "You are climbing on the ladder", "You are very tightly holding on the rusty metal ladder, but your grip is starting to get loose. \nIt feels as if something is almost physically pulling you down, making it harder not to fall. \nYou are not sure if you are even climbing downwards. \nYou are doubting your own thoughts, as it feels like letting go would be the only solution. \nThe ladder continues down."))
    addArea(Area("caveladder9", "You are climbing on the ladder", "You are barely holding on the rusty metal ladder. \nYour consciousness is starting to drift off. \nIt feels like your are being wrapped up by the darkness around you. \nThe ladder continues downwards."))
    addArea(Area("caveladder10", "You are climbing on the ladder", "You are holding on the rusty metal ladder with your last bit of strength. \nIt's hard to stay awake. You are not sure how long you have been climbing down. \nThe ladder continues downwards."))
    addArea(Area("caveladder11", "You are climbing on the ladder", "You are holding on the rusty metal ladder with your very last bit of strength. \nYou are pushing your limit. You keep drifting off and waking up immediately. \nSurprisingly, the headache is disappearing. \nThe ladder continues downwards."))
    addArea(Area("caveladder12", "You are climbing on the ladder", "Your grip is loosening on the rusty metal ladder. \nYour leg touches something solid below you. \nYou feel normal again and are not sure what just happened.\nThe ladder continues downwards."))
    addArea(new Area("cave start room", "Small cave turned into a room", Buffer("You are standing in a cave lit by torches on the walls. \nThe walls have wooden pillars going up to the ceiling. They seem to serve no purpose other than decorative.\nAt the northern side of the room there is wooden wall with a door that is slighty ajar. \nA slight breeze of wind seems to be coming from there. \nThe ladder goes up, but you'd rather not go back up that way.")) {
      override def arrive(direction: String, adventure: Adventure): String = {
        if (!adventure.countdownEnabled) {
          adventure.countdownEnabled = true
          super.arrive(direction, adventure) + "\n\nYou get the feeling that you shouldn't linger in this cave for too long."
        } else {
          super.arrive(direction, adventure)
        }
      }
    })
    addArea(Area("cave balcony", "Balcony overlooking the big hall", "You are standing on a stone balcony quite high up the wall, overlooking a big hall. \nBelow you, going around the circuclar hall are rows of chairs. \nIn the middle is a circular stone platform decorated with candles and bones.\nFigures with black hooded robes are praying around it. Their prayers echo around the hall. \nOn the wall opposite of you, you can see a large double sided wooden door.\nThey don't seem to notice you."))
    addArea(Area("cave first hallway", "Hallway in the cave", "You are standing in a hallway lit by torches on the walls. The air is humid.\nSouth of you is the door to the crate room. \nAt the northern end of the hallway is an opening in the wall. You can see a big hall of some sort through it. \nThe hallway curves east, where there is a staircase going down."))
    addArea(Area("cave staircase", "Lower end of the staircase in the cave", "You are standing at the lower end of the staircase. There is a torch lit hallway going towards east with two different paths. The air is humid.\nThe hallway curves to the north behind a corner. \nThe hallway curves south towards a door. \nEast of you is a door."))
    addArea(Area("cave lower hallway1", "Hallway in the lower floor of the cave", "You are standing in a hallway in the lower floor of the cave. \nThe hallway continues north towards an opening in the distance. In the middle of the hallway is another corner towards west. \nThe air is humid.\nYou feel a breeze on your face."))
    addArea(Area("cave lower door1", "In front of a door in the lower floor of the cave", "You are standing in front of a sturdy looking wooden door with metal barred hole at the top. \nThe air is humid.\nYou can hear rattling of shackles from the other side.\nTo the north is the hallway."))
    addArea(Area("cave library", "A room with bookcases in the lower floor of the cave", "You are standing in a room dimly lit by candles. The dusty air makes you cough. \nThere are many bookcases here filled with different sized books. \nOn the eastern wall closests to you, there is a wooden desk with some books and papers on it. \nWest of you is the door to the hallway. \nThere is a also a ladder here going up. It has a sign saying \"Lighthouse\". \nYou could use this to escape."))
    addArea(Area("cave escape ladder", "Halfway the ladder going to the lighthouse", "You are climbing the ladder. \nBelow you is the library. \nIf you truly want to end your investigation so soon, continue up towards the hatch."))
    addArea(Area("cave lower hallway door", "Hallway in the lower floor of the cave", "You are standing at the end of the hallway that curved east. \nThere is a big wooden double door here.\nEast of you is the hallway."))
    addArea(Area("cave opening lower", "Lower area in the opening in the cave", "You are standing at the entrance to a huge opening in the cave. The stone floor raises to the north. You can't see over it from here. \nThere are floor candelabras with candles near the walls. \nA decorative red rug leads a stairway up the crag to the north. \nThe air is humid. \nYou feel a breeze on your face. \nThe hallway is to the south."))
    addArea(Area("cave opening upper", "Upper area in the opening in the cave", "You are standing at the top of the stairway. \nBefore you is a huge opening in the cave filled with water.\nIt seems to continue far off into the distance, possibly towards the sea. \nThe waves are crashing to the cliff few meters below you. \nThe roaring of the waves echo in the cave. \nThere is a stone altar before the cliff.\nThere is a huge brass horn next to the altar.\nThere are also various organs on the altar, some dripping blood on to the floor. \nThe stairway downwards is to the south of you."))
    addArea(new Area("unaccessible forest", "Unaccessible Forest", Buffer("You don't want to give up your investigation so soon.")) {
      override def arrive(direction: String, adventure: Adventure): String = {
        this.description
      }
    })
    addArea(new Area("cave lighthouse exit", "Exit from the cave", Buffer("Exit from the cave to the lighthouse")) {
      override def arrive(direction: String, adventure: Adventure): String = {
        adventure.quitted = true
        "You decide to end your investigation in the town of Adbury. The mystery was never solved."
      }
    })

    val graveyardEntrance = Area("graveyard entrance", "Gravel path going to graves", "You are at a crossroads, three of the directions go towards areas that seem to have many graves at them.\nTo the south you see the gravel road go towards the front of the church.\nThe road going west has a sign on it that says \"Western section\"\nThe road going north has a sign on it that says \"Northern section\"\nThe road going east has a sign on it that says \"Eastern section\"")
    addArea(graveyardEntrance)

    areas("cave escape ladder").link(areas("cave lighthouse exit"), "up")

    areas("adbury gates").link(areas("unaccessible forest"), "west")
    areas("adbury gates").link(areas("unaccessible forest"), "south")
    areas("adbury gates").link(areas("unaccessible forest"), "east")
    areas("adbury gates").link(areas("adbury gates inside"), "north")
    areas("adbury gates inside").link(areas("tavern"), "west")
    areas("tavern").link(areas("tavern counter"), "west")
    areas("adbury gates inside").link(areas("market square south"), "north")
    areas("market square south").link(areas("market square north"), "north")
    areas("market square south").link(areas("general store porch"), "west")
    areas("market square south").link(areas("park road"), "east")
    areas("park road").link(areas("park"), "south")
    areas("park road").link(areas("lighthouse street"), "east")
    areas("park").link(areas("cave outside"), "east")

    areas("lighthouse street").link(areas("lighthouse hill 1"), "east", "south")
    areas("lighthouse hill 1").link(areas("lighthouse hill 2"), "north")
    areas("lighthouse hill 2").link(areas("lighthouse hill 3"), "north")
    areas("lighthouse hill 3").link(areas("stone path end"), "north")
    areas("lighthouse hill 3").link(areas("lighthouse door"), "west")
    areas("stone path end").link(areas("pier"), "north")
    areas("lighthouse door").link(areas("lighthouse first"), "north")
    areas("lighthouse first").link(areas("lighthouse second"), "up")
    areas("lighthouse second").link(areas("lighthouse third"), "up")
    areas("lighthouse third").link(areas("lighthouse fourth"), "up")
    areas("lighthouse fourth").link(areas("lighthouse top"), "up")

    areas("market square north").link(areas("church street first"), "east", "south")
    areas("church street first").link(areas("church street second"), "north")
    areas("church street first").link(areas("church doorstep"), "east")
    areas("market square north").link(areas("living quarters first"), "west", "south")
    areas("living quarters first").link(areas("living quarters second"), "north")
    areas("living quarters second").link(areas("church street second"), "east", "north")
    areas("living quarters second").link(areas("old house"), "west")
    areas("old house").link(areas("old house bedroom"), "west")
    areas("old house").link(areas("old house kitchen"), "north")

    areas("church street second").link(areas("warehouse alleyway"), "west")

    areas("church doorstep").link(areas("graveyard entrance"), "north")
    areas("church doorstep").link(areas("church inside"), "east")
    areas("church inside").link(areas("church altar"), "east")
    areas("church inside").link(areas("church basement up"), "north")
    areas("church basement up").link(areas("church basement down 1"), "down")
    areas("church basement down 1").link(areas("church basement down 2"), "east")

    areas("cave entrance").link(areas("caveladder1"), "down")
    areas("caveladder1").link(areas("caveladder2"), "down")
    areas("caveladder2").link(areas("caveladder3"), "down")
    areas("caveladder3").addSingleLink(areas("caveladder4"), "down")
    areas("caveladder4").addSingleLink(areas("caveladder5"), "down")
    areas("caveladder5").addSingleLink(areas("caveladder6"), "down")
    areas("caveladder6").addSingleLink(areas("caveladder7"), "down")
    areas("caveladder7").addSingleLink(areas("caveladder8"), "down")
    areas("caveladder8").addSingleLink(areas("caveladder9"), "down")
    areas("caveladder9").addSingleLink(areas("caveladder10"), "down")
    areas("caveladder10").addSingleLink(areas("caveladder11"), "down")
    areas("caveladder11").addSingleLink(areas("caveladder12"), "down")
    areas("caveladder12").addSingleLink(areas("cave start room"), "down")

    areas("cave start room").link(areas("cave first hallway"), "north")
    areas("cave first hallway").link(areas("cave balcony"), "north")
    areas("cave first hallway").link(areas("cave staircase"), "east")
    areas("cave staircase").link(areas("cave lower hallway1"), "north")
    areas("cave staircase").link(areas("cave lower door1"), "south")
    areas("cave staircase").link(areas("cave library"), "east")
    areas("cave lower hallway1").link(areas("cave lower hallway door"), "west")
    areas("cave library").link(areas("cave escape ladder"), "up")
    areas("cave lower hallway1").link(areas("cave opening lower"), "north")
    areas("cave opening lower").link(areas("cave opening upper"), "up")

    // The graveyard consists of first three different directions, East, North, West.
    // In each of these directions is another crossroad with sections A, B and C, where each letter is a direction depending on where you came from.
    // In each of these then are three graves 1, 2, 3 where each number is one direction, depending on where you came from.
    // Player CAN guess, but the point is to find a hint from somewhere else not too tough
    // (Family blah blah was buried in Northern section. Youngest are in the A section and elders in C, and then the three graves are from age as well
    // so the oldest kid would be in the grave number 3.

    // the graveyard is a tree of height 3 with 3 children in each internal node. graveyardEntrance is the root.
    val cardinals = Vector("north", "east", "south", "west")
    val letters = Vector("A", "B", "C")
    val directions1 = Vector(3, 0, 1) // indices for clockwise cardinal directions, excluding south from whence the player came from
    for (cardinal1 <- directions1) {
      val backDirection1 = (cardinal1 + 2) % 4 // the opposite direction
      val directions2 = directions1.map(_.+(cardinal1).%(4)) // get direction indices, offset by the path choice taken
      var keyTemplate = "graveyard " + cardinals(cardinal1)
      val letterPaths = (0 until 3).map(i => ("\nThe road " + cardinals(directions2(i)) + " going has a sign on it that says \"Section " + letters(i) + "\".")).mkString
      val sectionArea = Area(keyTemplate, "A crossroads at the " + cardinals(cardinal1) + "ern section of the graveyard", "You are at a crossroads three of the directions go towards areas that seem to have some graves at them.\nTo the " + cardinals(backDirection1) + " is a gravel road going towards another crossroads." + letterPaths)
      graveyardEntrance.link(sectionArea, cardinals(cardinal1))
      addArea(sectionArea)
      for (i <- 0 until 3) {
        val cardinal2 = directions2(i)
        val backDirection2 = (cardinal2 + 2) % 4
        val directions3 = directions1.map(_.+(cardinal2).%(4)) // (source vector is still directions1 because directions are represented as absolutes instead of relative to last node)
        var keyTemplate2 = keyTemplate + " " + letters(i)
        val letterArea = Area(keyTemplate2, "Graveyard " + cardinals(cardinal1) + "ern section", "You are standing in front of three graves.\nTo the " + cardinals(backDirection2) + " you see a gravel crossroad.\nGo " + cardinals(directions3(0)) + " for the first grave, " + cardinals(directions3(1)) + " for the second and " + cardinals(directions3(2)) + " for the third.")
        sectionArea.link(letterArea, cardinals(cardinal2))
        addArea(letterArea)
        for (j <- 0 until 3) {
          val cardinal3 = directions3(j)
          val backDirection3 = (cardinal3 + 2) % 4
          val keyTemplate3 = "grave " + cardinals(cardinal1) + " " + letters(i) + " " + (j + 1)
          val grave = Area(keyTemplate3, "Graveyard " + cardinals(cardinal1) + "ern section grave", Buffer("You are standing in front of an old stone grave. The name is completely unreadable because of all the moss and dirt on it.\n" + cardinals(backDirection3).capitalize + " of you is the gravel road.", "An old stone grave. The name is completely unreadable because of all the moss and dirt on it. The ground has been dug and it has revealed a coffin."))
          letterArea.link(grave, cardinals(cardinal3))
          addArea(grave)
        }
      }
    }

    val spade = new Item("spade", Buffer("It's an old wooden spade with a rusty metal end. Still good for digging.")) {
      override def use(adventure: Adventure) = {
        if (adventure.player.location.name.startsWith("grave ") && !adventure.player.location.interests.contains("coffin")) {
          adventure.player.location.descriptionIndex += 1
          var coffin = new Item("coffin", Buffer("A dark wooden coffin. The inside is lined with purple velvet. \nThere is a rotting skeleton inside. The sight makes you feel sick."))
          if (adventure.player.location.name == "grave east B 2") {
            println("2")
            coffin = new Item("coffin", Buffer("A dark wooden coffin. The inside is lined with purple velvet. \nThere is a key inside.", "A dark wooden coffin. The inside is lined with purple velvet. It's empty."))
            val oldKey = new Item("old key", Buffer("A metal key covered in dirt. The end is shaped like a some sort a fish.")) {
              override def use(adventure: Adventure) = {
                if (adventure.player.location.name == "cave outside" && adventure.player.location.interests.contains("door")) {
                  val caveDoor = adventure.player.location.interests("door")
                  caveDoor.descriptionIndex += 1
                  adventure.player.inventory -= "old key"
                  areas("cave outside").link(areas("cave entrance"), "east")
                  "The old key fits the metal lock. You turn it and hear a satisfying click as the lock unlocks and falls off the metal bar."
                } else { super.use(adventure) }
              }
            }
            coffin.itemInInterest = Some(oldKey)
          }
          adventure.player.location.addInterest(coffin)
          "You dig up the soft ground and reveal a coffin."
        } else {
          super.use(adventure)
        }
      }
    }

    areas("cave library").addInterest(new Item("desk", Buffer("There is an old worn book on the desk with metal decorations of tentacles on the cover. \nThere seem to be pages ripped out of the book from various parts. \nOne page is bookmarked and reads: \"For he shall rise once more, he who sleeps deep under the waves.\" \nThe ritual is to be performed before the storming sea. \n ")))

    val rope = new Item("rope", Buffer("A coil of rope. It's quite strong and could probably hold your weight.")) {
      override def use(adventure: Adventure) = {
        if (adventure.player.location.interests.contains("window")) {
          val window = adventure.player.location.interests("window")
          areas("warehouse alleyway").link(areas("warehouse"), "up", "north")
          adventure.player.inventory -= this.name
          window.descriptionIndex += 1
          "You tie a knot onto the rope and throw it up the window. It's tightly attached."
        } else { super.use(adventure) }
      }

      override def get(adventure: Adventure) = {
        adventure.player.location.descriptionIndex += 1
        super.get(adventure)
      }
    }

    val rug = new Item("rug", Buffer("You notice there is something peeking from under the rug and decide to move it. \nYou reveal a trapdoor from under it.", "You have moved the rug to the side, revealing a trapdoor.")) {
      override def examine(adventure: Adventure): String = {
        if (this.descriptionIndex == 0) {
          val result = this.description
          this.descriptionIndex += 1
          adventure.player.location.descriptionIndex += 1
          areas("old house bedroom").link(areas("old house basement"), "down")
          result
        } else { this.description }
      }
    }

    areas("old house bedroom").addInterest(rug)
    areas("pier").addItem(rope)
    areas("old house basement").addInterest(new Item("notes", Buffer("Crumpled notes that have been written in black ink. \nThe text speaks of a cult of some sort that started spreading in the town. \nTheir goals are unknown, but apparently they should be stopped at all costs. \nThe rest of the text is too messy to read.")))
    areas("cave opening upper").addInterest(new Item("altar", Buffer("A bloody stone altar. It is decorated with candles and bones. \nVarious organs have been placed on the middle. \nSome of them are still dripping blood. \nThe sight makes you feel sick.")))
    val desklighthouse = new Item("desk", Buffer("A crudely built wooden desk with books of different sizes and papers scattered all over it.\nOne paper with names catches your eye.", "A crudely built wooden desk with books of different sizes and papers scattered all over it."))
    areas("lighthouse first").addInterest(desklighthouse)
    val deceasedlist = new Item("paper", Buffer("A page ripped out of a book. It reads: \n\"Those who are deceased: \nRobert J. Hemmers - 62 \nAlfred O. Hemmers - 45 \nAlice K. Hemmers - 56 \nHenry W. Jones - 72 \nMarion Y. Jones - 68 \nHenry W. Jones - 14 \nMary Y. Jones - 42 \nEdward J. Crowley - 73 \nHenrietta N. Crowley - 76\nAdam N. Crowley - 41 \nHenry N. Crowley - 45   \" \nThe last name is circled with ink. "))
    desklighthouse.itemInInterest = Some(deceasedlist)
    val bookcaselighthouse = new Item("bookcase", Buffer("A dark wooden bookcase. The shelves are dusty. \nThere are different sized books here. \nA single book is slightly sticking out.", "A dark wooden bookcase. The shelves are dusty. \nThere are different sized books here."))
    areas("lighthouse second").addInterest(bookcaselighthouse)
    val familybook = new Item("book", Buffer("A book labeled Adbury family history. The bookmark is on a page that reads: \n\"Burial sites: \nWestern section is reserved for the Hemmers family. \nNorthern section is reserved for the Jones family. \nEastern section is reserved for the Crowley family.  \nEach section is to be set in areas A,B and C, \nWhere A is to have ages from 1 to 17, B ages from 18 to 55 and C ages 56 and older. \nGraves are to be dug in order of when the family member departed.\" \nAnother bookmark is on the page that tells of the Crowley family: \n\"At the time of writing, Crowley family consisted of Edward J. Crowley, his wife Henrietta N. Crowley and their recently born triplets \nAdam N. Crowley, Henry N. Crowley and Robert N. Crowley.\""))
    bookcaselighthouse.itemInInterest = Some(familybook)
    areas("cave lower door1").addInterest(new Item("door", Buffer("A sturdy looking wooden door with metal barred hole at the top. It doesn't budge. \nLooking through the barred hole you can see a a dark room. \nYou barely make out some cages and some figures moving in them. \nYou can hear the rattling of shackles.")))
    areas("tavern counter").addInterest(new Item("gregory", Buffer("A burly looking man with a bushy beard.\nHe looks quite threatening.\nHe seems to be ignoring you completely.")))
    val cavedoor = new Item("door", Buffer("An old, but sturdy looking wooden door. \nIt is blocked by a metal bar that has a big lock at the end.", "An old, but sturdy looking wooden door. \nThe lock has been unlocked and the metal bar isn't blocking the doorway anymore."))
    areas("cave outside").addInterest(cavedoor)
    val woodencrate = new Item("crates", Buffer("Quite large wooden crates. \nOne of them is open and there is a spade in it.", "Quite large wooden crates."))
    woodencrate.itemInInterest = Some(spade)
    areas("church basement down 2").addInterest(woodencrate)
    val oldhousekitchentable = new Item("table", Buffer("On the kitchen table there are various pots and pans that have their lids thrown on the floor.\nThere is also a rusty lantern sitting on the table.", "On the kitchen table there are various pots and pans that have their lids thrown on the floor."))
    areas("old house kitchen").addInterest(oldhousekitchentable)
    val lantern = new Item("lantern", Buffer("A badly rusted lantern. Despite it's condition, it seems usable. It's missing a candle.", "A badly rusted lantern. Despite it's condition, it seems usable.\nIt has a candle inside.\nYou can now access dark areas.")) {
      override def get(adventure: Adventure) = {
        adventure.player.location.interests("table").descriptionIndex += 1
        super.get(adventure)
      }
    }
    areas("old house kitchen").addItem(lantern)
    areas("lighthouse second").addInterest(new Item("painting", Buffer("Dust covered paintings on people. Their facial features are drawn in wrong proportions, as if the painter forgot how faces looked like.")))
    val cavebookcase = new Item("bookcase", Buffer("The bookcases are made out of dark wood that has twists and curves, as if it grew in that shape. \nThe wood looks very old. \nThe amount of books in the shelves is too much for you to start examining them one by one."))
    areas("cave library").addInterest(cavebookcase)
    areas("warehouse alleyway").addInterest(new Item("window", Buffer("The window is almost completely shattered. \nIt is too high up the wall for you to reach without something to climb on.", "The window is almost completely shattered. \nYou have thrown and attached a rope up the window.\nIt can be climbed up.")))
    areas("church doorstep").addInterest(new Item("mural", Buffer("The wall around the door has a vine covered mural painted on it.\nIt's depicting winged looking creatures carrying people up to the heavens.")))
    val altarinchurch = new Item("altar", Buffer("There are bouquets of roses placed neatly on the altar. \nThere also seems to be incense burning in small pots on top of it, as well as recently lit candles. The smell is intense. \nSome of the candles have fallen on the floor. "))
    areas("church altar").addInterest(altarinchurch)
    val candle = new Item("candle", Buffer("A white wax candle. It smells strange."))
    areas("church altar").addItem(candle)
    val coffinempty = new Item("coffin", Buffer("The old stone coffins are empty. There is nothing but dust in them."))
    areas("church basement down 2").addInterest(coffinempty)
    areas("church basement down 1").addInterest(coffinempty)
    val fountain = new Item("fountain", Buffer("An oddly terrifying fountain depicting a man covering in fear.\nIt doesn't seem to be working."))
    areas("market square north").addInterest(fountain)
    areas("market square south").addInterest(fountain)
    areas("general store porch").addInterest(new Item("barrel", Buffer("Wooden barrels. \nThey smell like rotten fish. \nUpon closer inspection it seems that they do indeed have rotting fish inside.")))
    areas("lighthouse top").addInterest(new Item("contraption", Buffer("The contraption in the middle seems to have been the source for the light. It looks like it has been broken on purpose.")))
    val cavehugedoor = new Item("door", Buffer("Two large doors made out of dark wood. \nThey have tentacle looking metal decorations all over them. \nThey look heavy. \nYou can hear echoing prayers from the other side.\nThere is a sturdy looking wooden bar on the floor next to the door. It could be used to block the door.", "Two large doors made out of dark wood. \nThey have tentacle looking metal decorations all over them. \nThey look heavy. \nYou can hear echoing prayers from the other side\nThe wooden bar is blocking the door. \nIt should keep the cultists inside."))
    val woodenbar = new Item("bar", Buffer("A sturdy looking wooden bar. It could be used to block a door.")) {
      override def use(adventure: Adventure) = {
        if (adventure.player.location.interests("door") == cavehugedoor) {
          adventure.player.inventory -= "bar"
          cavehugedoor.descriptionIndex += 1
          "You bar the door with the wooden bar."
        } else { super.use(adventure) }
      }
    }
    val page = new Item("page", Buffer("A page that seems to be ripped out of a book.\nIt has a sentences written in strange letters on it, but above them reads \n\"The sea's prayer. If thy desire's to anger the sea, beseech these words after thy ritual in order: gn'th lloigazath nafl'fhtagn\".")) {
      override def use(adventure: Adventure) = {
        if (adventure.player.location.name == "cave opening upper") {
          adventure.isComplete = true
          if (cavehugedoor.descriptionIndex == 1) {
            "You decide to try to pronounce the strange sentences into the brass horn. \nAs you finish, the water starts bubbling and it seems like the waves are getting stronger. \nThe roaring waves echo strongly around the cave. \nIt's as if the sea were a boiling pot, overflowing. \nYou hear a loud rumbling from far off in the cave going towards the sea. \nYou see the water level rise and decide to flee. \nYou run towards the library, grab some books from the room for evidence and start climbing the ladder in a hurry. \nAs you climb, you see the room below you floods with bubbling sea water. \nYou manage to open the hatch above you and climb up into the lighthouse. \nYou let out a sigh of relief.\nSince you barred the doors to the big hall, the cultists couldn't escape fast enough and perished. \nYou managed to escape the town of Adbury with evidence of the cultists horrifying deeds. \nYou also managed to stop their ritual before it was too late. \nYou are not sure what happened to the town after you published your findings, but you get the feeling the cult is gone for good. \n\n -- BEST ENDING -- "
          } else {
            "You decide to try to pronounce the strange sentences into the brass horn. \nAs you finish, the water starts bubbling and it seems like the waves are getting stronger. \nThe roaring waves echo strongly around the cave. \nIt's as if the sea were a boiling pot, overflowing. \nYou hear a loud rumbling from far off in the cave going towards the sea. \nSuddenly someone grabs you from behind. \nThe cultists found you. \nTheir faces seem to be horrifyingly morphed and seem squidlike, with slimy tentacles protruding from the lower half. \nYour hands are tied and your belongings are taken from you. \nThe cultists seem to celebrate as they notice the page you had and see what you had done. \nOne of them places a dark decorated book on the altar and starts chanting something in a strange language. \nYou see the water level rise and hear a loud roar from the end of the cave. \nYour head starts pounding and your mind is filled with various whispers in languages you can't understand. \nAs the cave starts shaking, you see a giant, indescribable creature rise from the depths. \nThe cultists cackle maniacly. \nBefore you can comprehend what is happening, you are knocked unconscious. \nYou were never heard from again. \nYou weren't able to stop the cultists from achieveing their goal. \nFrom that day forward, the world lived under the rule of terrifying nightmarish creatures. \n\n -- WORST ENDING --"
          }
        } else { super.use(adventure) }
      }

      override def get(adventure: Adventure) = {
        adventure.player.location.descriptionIndex += 1
        super.get(adventure)
      }
    }

    areas("old house basement").addItem(page)
    areas("cave lower hallway door").addItem(woodenbar)
    areas("cave lower hallway door").addInterest(cavehugedoor)
    areas("cave balcony").addInterest(new Item("figures", Buffer("They are too far away in the dimly lit hall to see clearly, but you can see that the figures are wearing black hooded robes.\nThey are kneeling in front of the altar in the middle, praying.\nTheir prayers echo around the hall.\nYou can't understand their words.\nYou get a strange feeling in your head while listening. ")))
    areas("pier").addInterest(new Item("sea", Buffer("You stare far off into the foggy sea.\nAfter a while, it feels as if something stares back. \nYou get chills and decide to stop staring.")))
    areas("market square north").addInterest(new Item("door", Buffer("The wooden double doors are quite large. They are locked tightly in chains and multiple locks.")))
    areas("cave opening upper").addInterest(new Item("horn", Buffer("A huge brass horn that is facing you. \nIt has two pipes, one leading towards the cave and one going underwater. \nThe howling wind seems to be amplified by it.")))

    areas("warehouse").addInterest(new Item("lamp", Buffer("You decide to rub the antique lamp.\nDark smoke emerges from the lamp and flies out of the window.\nYou have a bad feeling about this.", "You decide to rub the antique lamp.\nNothing happens.")) {
      override def examine(adventure: Adventure) = {
        if (!adventure.grueLocation.isDefined) {
          adventure.grueLocation = Some(areas.values.toVector(adventure.rng.nextInt(areas.size)))
          //  println(s"grue starts at ${adventure.grueLocation.get.name}") // debug
          val result = super.examine(adventure)
          this.descriptionIndex += 1
          result
        } else {
          super.examine(adventure)
        }
      }
    })

    areas
  }
}

