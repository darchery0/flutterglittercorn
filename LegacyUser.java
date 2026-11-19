// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.communityapp.data.DatabaseConnection;

public class UserDAO {
   public UserDAO() {
   }

   public static ArrayList<LegacyUser> getAllUsers() {
      ArrayList var0 = new ArrayList();
      String var1 = "SELECT * FROM users";

      try {
         Connection var2 = DatabaseConnection.getConnection();

         ArrayList var14;
         label109: {
            try {
               if (var2 == null) {
                  var14 = var0;
                  break label109;
               }

               Statement var3 = var2.createStatement();

               try {
                  ResultSet var4 = var3.executeQuery(var1);

                  try {
                     while(var4.next()) {
                        LegacyUser var5 = new LegacyUser(var4.getInt("id"), var4.getString("username"), var4.getString("email"), var4.getString("role"));
                        var0.add(var5);
                     }
                  } catch (Throwable var10) {
                     if (var4 != null) {
                        try {
                           var4.close();
                        } catch (Throwable var9) {
                           var10.addSuppressed(var9);
                        }
                     }

                     throw var10;
                  }

                  if (var4 != null) {
                     var4.close();
                  }
               } catch (Throwable var11) {
                  if (var3 != null) {
                     try {
                        var3.close();
                     } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                     }
                  }

                  throw var11;
               }

               if (var3 != null) {
                  var3.close();
               }
            } catch (Throwable var12) {
               if (var2 != null) {
                  try {
                     var2.close();
                  } catch (Throwable var7) {
                     var12.addSuppressed(var7);
                  }
               }

               throw var12;
            }

            if (var2 != null) {
               var2.close();
            }

            return var0;
         }

         if (var2 != null) {
            var2.close();
         }

         return var14;
      } catch (SQLException var13) {
         System.err.println("Error retrieving users: " + var13.getMessage());
         return var0;
      }
   }
}
