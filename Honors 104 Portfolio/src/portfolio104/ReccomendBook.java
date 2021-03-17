package portfolio104;

import java.util.*;

public class ReccomendBook {
	
  //def var for print dashes
  static String dashes = repeatChar('-', 95);
  
  //initialize scanner
  static Scanner sc = new Scanner(System.in);
  
  //-------------------------------------------------------
  //main - take user input for two questions
  //-------------------------------------------------------
	public static void main(String[] args) {
	  //initialize string to determine if program continues
	  String keepGoing = "";
    //introduce program to user
    System.out.println("\nThis program recommends recent books based on the theme preferences of the user!");
    System.out.println("\n"+ dashes);
    
	  //while user wants to continue, execute.
	  while (!keepGoing.toLowerCase().equals("n")) {	    
  	  //call questions method 
  	  String userPref = questions();
  	  //call recommendation method 
  	  String book = recommendation(userPref);
  	  //call print method
  	  printOutput(book);
  	  System.out.println("Would you like to try again? (y or n)");
  	  keepGoing = sc.nextLine();
	  }
	  sc.close();
	  //if user wants to quit, print message. z
	  if (keepGoing.toLowerCase().equals("n")) {
	    System.out.println("Goodbye.");
	  }
	}
	
	//-------------------------------------------------------
	//questions - take user input for two questions
	//-------------------------------------------------------
	public static String questions() {
	  //ask question 1: 
	  System.out.println("Which theme are you most interested in reading about? \n"
			  + "{Autonomy(a), Collectivism vs Individualism(b), or Control(c)} -> (enter 'a', 'b', or 'c')");
	  String answer1 = sc.nextLine();
	  //ask question 2: 
	  System.out.println("\nWhich secondary theme are you most interested in? \n"
	  		  + "{Bureaucracy(x),  Choice of Life vs. Death(y), or Perfection(z)} -> (enter 'x', 'y', or 'z')");
	  String answer2 = sc.nextLine(); 
	  //create string of two answers
	  String combo = answer1 + answer2;
	  return combo;
	}
	
	//-------------------------------------------------------
	//Recommendation - make book recommendation
	//-------------------------------------------------------
	public static String recommendation(String userPref) {
		//initialize string
	  String bookRecommend;
	  //case statement selects book given userInputs
	  switch (userPref) {
	  case "ax": 
	    bookRecommend = "The Hunger Games";
	    break;
	  case "ay":
      bookRecommend = "The Program";
      break;
	  case "az":
      bookRecommend = "Origin";
      break;
	  case "bx":
      bookRecommend = "Gone";
      break;
	  case "by":
      bookRecommend = "Delirium";
      break;
	  case "bz":
      bookRecommend = "The Toll";
      break;
	  case "cx":
      bookRecommend = "Mockingjay";
      break;
	  case "cy":
      bookRecommend = "Scythe";
      break;
	  case "cz":
	     bookRecommend = "matched";
	     break;
	  default:
	    bookRecommend = "Invalid input. \nPlease enter (a, b, or c) and (x, y, or z) as you inputs.";
		}
		//return recommendation
	  return bookRecommend;
	}
	
	//-------------------------------------------------------
  // bookSynop - return synopsis of selected book
  //-------------------------------------------------------
	public static String bookSynop(String book) {
	  //initialize string
	  String synop;
	  //case statement selects synopsis for book recommended
	  switch (book) {
	  case "The Hunger Games":
	    synop = "  In this iconic 2008 novel by Suzanne Collins, the Hunger Games are a manifestation of the overpowering bureaucracy \n"
	        + " of a Capitol that rules over the rest of the nation. In an effort to keep citizens submissive, an annual event is \n"
	        + "designed to remind people of the hierarchy that permits their access to life. Even those who “win” in these games, \n"
	        + "designed to strip people of their autonomy and bend them to the will of the Capitol, must survive by maintaining the \n"
	        + "narrative of their bureaucratic oppressors.\n"
	        + "  The theme of autonomy in the context of bureaucracy is exemplified by Kohlhaas’s choice to take justice into his own \n"
	        + "hands. The bureaucratic system failed him and he chose to act of his own accord, even if it meant his eventual death. \n"
	        + "On page 50, the author writes: “A tear coursing down his cheek, Kohlhaas replied: Sir! It cost me my wife; it is Kohlhaas’s \n"
	        + "wish to prove to the world that she did not perish in an unjust cause”. From this, it is clear that he is done with the \n"
	        + "bureaucratic game of society and is willing to push back at any additional cost. He has already lost that which was most \n"
	        + "dear to him.\n";
	    break;
    case "The Program":
      synop = " The Program is not desired. In the future, teen suicide has become an epidemic. In order to slow the spread, \n"
          + "the Program was created. Those who are deemed at-risk are forced into specialized hospitals where their memories \n"
          + "are slowly, systematically erased, leaving them healthy, but shells of their former selves. Suzanne Young’s 2013 \n"
          + "novel sheds a light on the cost of interfering in the lives of others, even if it is done to help them. Readers \n"
          + "will call into question their own morals around the autonomy of death and reevaluate what they would be willing \n"
          + "to do for someone who’s struggling.\n"
          + " The character of Bartleby embodies the themes of Autonomy and the choice between life and death.  We see Bartleby \n"
          + "exercise his personal autonomy on countless occasions throughout the text as he declines requests to perform his \n"
          + "job with the simple reply of  “I would prefer not”. Inexplicably, the narrator finds himself willing to go to great \n"
          + "lengths for Bartleby, even offering to let him stay at his home. He appears to pity Bartleby and attempts to sympathize \n"
          + "with him rather than fire him or otherwise cast him out. Furthermore, the text ends with Bartleby choosing to starve \n"
          + "himself to death rather than go on living in his current state.\n"
          + "";
      break;
    case "Origin":
      synop = " She was bred in secret to be immortal. Perfection is all that is known. But when she has a chance to make imperfect \n"
          + "choices, she realizes that she’s nothing more than a pawn. In 2012, Jessica Khoury pushed readers to consider the \n"
          + "price of perfection. Though it may come with beautiful trimmings, in order to reach for this title, one must surrender \n"
          + "their autonomy. Whether through living out the preconceptions of others or through doing “what’s expected,” Khoury implies \n"
          + "that all of us live out a similar struggle of sacrifice. \n"
          + " In miscellany for Ephemera, the text “A Eugenics Catechism” discusses the methods of eugenics, one of which is sterilization \n"
          + "on a large scale (pg 33). This speaks to the theme of removing personal autonomy of a group of people in service of  achieving \n"
          + "'perfection' of the human race. Although perfection is something that is often sought, it’s clear that the tradeoffs aren't \n"
          + "always worth the potential gain. In searching for perfection in the “betterment” of the human race, the lives of many individuals \n"
          + "who are forcibly sterilized are potentially ruined. \n";
      break;
    case "Gone":
      synop = " Michael Grant’s Gone is often represented as a “more accurate” Lord of The Flies. When everyone over the age of fifteen \n"
          + "disappears and some kids begin developing advanced abilities, the games begin. Politics, greed, and prejudice are just the \n"
          + "tip of the iceberg in this 2008 sci-fi saga. The young teens must work together to build a structure in which all of the kids \n"
          + "will have the best chance of survival, even the infants. Conflict is only intensified by those who call for the new system \n"
          + "to allow them complete freedom from consequence and freedom from the binds of collective survival. \n"
          + " Karl Marx’s Communist Manifesto is centered around the idea of promoting the collective good at the expense of individualism. \n"
          + "He proposes “capital is a collective product… therefore, capital is converted into common property” (pg 72). In Marx’s perfect \n"
          + "world, Bureaucracy would dictate what individualistic sacrifices must be made in service of the collective good. \n";
      break;
    case "Delirium":
      synop = " Love is a disease. It makes people do things that are counterproductive to society; Therefore, it’s removed, leaving people \n"
          + "with little emotion. But when the deliria strikes, when the emotions flood, when you wish to die, you can’t. You’re locked up \n"
          + "in a prison so that you don’t disturb the others. Lauren Oliver’s 2011 Delirium, seeks to cast a light on the idea of death \n"
          + "and its function in a collectivist society. Death in modernity is an individual experience, however, Oliver ensures that readers \n"
          + "see how easily that can be altered. \n"
          + " In Defoe’s Plague Year, we get a glimpse into what it must have been like to live through strict lockdowns to prevent the spread \n"
          + "of the disease. On page, 53 Defore writes: “To every infected house there be appointed two watchmen. No person is to go in or out \n"
          + "of such infected houses.” Given the circumstances of the time, leadership is forced to decide how to proceed, and what personal freedoms \n"
          + "should be sacrificed for the collective good. This text also explores the drastic choices that many had to make when deciding how to best /n"
          + "protect themselves. Those condemned to death in an infected house made daring escapes under the noses of watchmen. \n";
      break;
    case "The Toll":
      synop = "Neal Shusterman’s final book of his Arc of a Scythe series follows multiple characters who do the work of collectivism in an individualist \n"
          + "society. Throughout the entire series, there have been those who take advantage of these systems and the underlying question persists of what \n"
          + "the perfect solution should be. In The Toll, the solution is finally discovered and readers realize Shusterman’s claim of what sacrifices must \n"
          + "be made in any society in order to ensure prosperity. But even then, it’s not perfect.\n"
          + "  The Communist Manifesto was created by Marx in an attempt to spread word of what he considered to be a “perfected” societal structure. Naturally, \n"
          + "perfection is subjective, and Marx came to his conclusion through his belief that the collective good is above that of the individual. The unfortunate \n"
          + "tradeoff for this “perfect society” is the loss of individualism. \n";
      break;
    case "Mockingjay":
      synop = " In Suzanne Collin’s third installment of The Hunger Games series, control is levied not only from the bureaucratically oppressive government \n"
          + "but also from the rebelling faction that seeks to take power over the nation. Readers are plagued with the question of the lesser of two evils \n"
          + "and the looming idea that there may be no system that operates without the need for control over people. \n"
          + "  The themes of control and bureaucracy can be clearly seen paralleled in the text Michael Kohlhaas. In the process of over-exerting authority, \n"
          + "the Junker pushes him to file complaints against him, only for the bureaucratic system to fail. This leads Kohlhaas on his crusade to enact revenge \n"
          + "on the Junker. On page 40 and in several other locations throughout the book, the author describes the decimation of towns that Kohlhaas set on fire. \n"
          + "This demonstrates his selfish view of the world. Although justified in his hatred for the Junker, he is inflicting further pain on innocent bystanders. \n";
      break;
    case "Scythe":
      synop = " When all death has been conquered, how do you manage the population? When there is an all-knowing, logical entity, how do you determine morals? The \n"
          + "answer in Neal Shusterman’s 2016 novel, is people. Individual human beings are the only ones who may dictate death and control right and wrong. They are \n"
          + "the scythes. They are supposed to be humble and accountable. They are not to enjoy their jobs as life-enders. But some do. And who controls the ones who \n"
          + "control? This novel launches Shusterman’s thought-provoking trilogy as it explores the extent to which our autonomy of death is controlled and how human \n"
          + "beings seek power over each other.\n"
          + "  In the Penal Colony explores some preconceived notions about justice and the control that an individual has over their own fate. On page 145, the Office \n"
          + "says “He has had no chance of putting up a defense” to the explorer. Unlike the justice system that we experience in the US, an individual is immediately \n"
          + "assumed guilty at the first accusation. The officer and other leaders in the colony exert full control over the citizens and can put them to death without \n"
          + "contradiction.\n";
      break;
    case "matched":
      synop = " Matched. Everyone is matched. To their jobs, to their homes, and to their lovers. The Society controls the matching to ensure harmony and happiness. To \n"
          + "ensure perfection. They also control what poems, stories, and songs will stand the test of time, destroying all the rest. Ally Condie’s 2010 novel prompts \n"
          + "readers to consider what they are willing to give up for security and comfort. While a life of job security and content marriages may sound wonderful, it only \n"
          + "exists because someone forced you into it. Are you okay with that?\n"
          + "  In A Eugenics Catechism, the author chooses to prescribe who are considered to be “emotional and mental defectives”. Lumped into this group are those who did \n"
          + "not graduate from the “lower grades of school”. If a governing body was to follow through with Eugenics practices, they would not only be controlling the \n"
          + "reproduction of members of society, but also prescribing those who are considered to be unfit arbitrarily. Who is to determine what makes someone unfit to \n"
          + "reproduce? What is considered to be the “perfect” human being? Is it reasonable to allow some governing body to determine this?\n";
      break;
     default:
       synop = "Error Encountered. Please try again.";
	  }  
	  return synop;
	}
	
	//-------------------------------------------------------
  // print - print recommendation to user
  //-------------------------------------------------------
	public static void printOutput(String recommendation) {
	  System.out.println("\nBased on your theme preferences, you would enjoy the book: " + recommendation);
	  System.out.println();
	  String blurb = bookSynop(recommendation);
	  System.out.println(blurb);
	  System.out.println("\n"+ dashes);
	}
	
	
	//-------------------------------------------------------
  // repeatChar - print string of chars nicely
  //-------------------------------------------------------	
	public static String repeatChar(char c, int length) {
	  char[] data = new char[length];
	  Arrays.fill(data,  c);
	  return new String(data);
	}
}


