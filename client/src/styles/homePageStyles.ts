import { StyleSheet } from 'react-native';


 export const HomeStyles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#000000',
  },
  header: {
    paddingTop : 40,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingHorizontal: 20,
    paddingVertical: 10,
    backgroundColor: '#000000',
  },

  imageContainer: {
    width: '100%',
    height: 150,
    position: 'relative',
  },
  topImage: {
    width: '100%',
    height: '100%',
  },
  gradientFade: {
    position: 'absolute',
    left: 0,
    right: 0,
    bottom: 0,
    height: 120,
  },

  greeting: {
    color: '#94A3B8',
    fontSize: 14,
  },
  userName: {
    color: '#F8FAFC',
    fontSize: 22,
    fontWeight: 'bold',
  },
  profileBadge: {
    backgroundColor: '#334155',
    padding: 10,
    borderRadius: 12,
    alignItems: 'center',
  },
  textProfile: {
    color: '#fff',
  },
  scrollContent: {
    paddingBottom: 120,
  },
  charCard: {
    backgroundColor: '#1E293B',
    borderRadius: 20,
    padding: 20,
    borderWidth: 1,
    borderColor: '#334155',
    marginBottom: 25,
  },
  charInfo: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 15,
    marginBottom: 20,
  },
  avatarPlaceholder: {
    width: 60,
    height: 60,
    backgroundColor: '#334155',
    borderRadius: 15,
    justifyContent: 'center',
    alignItems: 'center',
  },
  avatarEmoji: {
    fontSize: 30,
  },
  charName: {
    color: '#F8FAFC',
    fontSize: 18,
    fontWeight: 'bold',
  },
  charClass: {
    color: '#A855F7',
    fontWeight: '600',
  },
  buttonPrimary: {
    backgroundColor: '#7C3AED',
    paddingVertical: 12,
    borderRadius: 10,
    alignItems: 'center',
  },
  buttonText: {
    color: '#FFF',
    fontWeight: 'bold',
  },
  sectionTitle: {
    color: '#F8FAFC',
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 15,
    textAlign: 'center',
  },
  achievementList: {
    gap: 10,
    marginBottom: 25,
  },
  achievementItem: {
    flexDirection: 'row',
    backgroundColor: '#020617',
    padding: 15,
    borderRadius: 15,
    alignItems: 'center',
    gap: 15,
    borderWidth: 1,
    borderColor: '#1E293B',
  },
  achievementTextCont: {
    flex: 1,
  },
  achievementTitle: {
    color: '#F8FAFC',
    fontWeight: 'bold',
  },
  achievementDesc: {
    color: '#64748B',
    fontSize: 12,
  },
  textTituloPlaneta: {
    alignItems: 'center',
  },
  textTitulo: {
    fontSize: 24,
    color: '#fff',
    fontWeight: 'bold',
  },
});